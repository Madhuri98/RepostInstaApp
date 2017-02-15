package com.repost.insta.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.repost.insta.R;
import com.repost.insta.constant.Constant;
import com.repost.insta.utill.Utility;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by 9Brainz on 2/9/2017.
 */

public class ActivityRepostSave extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgRepostPhoto;
    private VideoView videoViewRepost;
    private FrameLayout layoutVideo;
    private Button btnRepost, btnSave, btnNoAds, btnMoreApps;
    private String PostLink, isVideo, VideoLink;
    private long number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repost_save);
        getWidgetReference();
        setStatements();
        eventHandler();
    }

    private void eventHandler() {
        btnRepost.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnNoAds.setOnClickListener(this);
        btnMoreApps.setOnClickListener(this);
//        imgPlayBtn.setOnClickListener(this);
    }

    private void setStatements() {
        if (isVideo.equals("video")) {
            layoutVideo.setVisibility(View.VISIBLE);
            imgRepostPhoto.setVisibility(View.GONE);
            MediaController mediaController = new MediaController(ActivityRepostSave.this);
            mediaController.setAnchorView(videoViewRepost);
            videoViewRepost.setMediaController(mediaController);
            videoViewRepost.setVideoPath(VideoLink);
            videoViewRepost.requestFocus();
            videoViewRepost.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoViewRepost.start();
                }
            });
        } else {
            layoutVideo.setVisibility(View.GONE);
            imgRepostPhoto.setVisibility(View.VISIBLE);

            Picasso.with(ActivityRepostSave.this)
                    .load(PostLink) //this is optional the image to display while the url image is downloading
                    .error(R.drawable.profile)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                    .into(imgRepostPhoto);
        }
        final File outputVideo = new File(Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name) + "/Videos");
        if (!outputVideo.exists())
            outputVideo.mkdir();
    }

    private void getWidgetReference() {
        number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

        PostLink = getIntent().getExtras().getString(Constant.KEY_POST_LINK);
        isVideo = getIntent().getExtras().getString(Constant.KEY_POST_ISVIDEO);
        VideoLink = getIntent().getExtras().getString(Constant.KEY_POST_VIDEOLINK);

        imgRepostPhoto = (ImageView) findViewById(R.id.imgRepostPhoto);
//        imgPlayBtn = (ImageView) findViewById(R.id.imgPlayBtn);
        layoutVideo = (FrameLayout) findViewById(R.id.layoutVideo);
        videoViewRepost = (VideoView) findViewById(R.id.videoViewRepost);

        btnRepost = (Button) findViewById(R.id.btnRepost);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnNoAds = (Button) findViewById(R.id.btnNoAds);
        btnMoreApps = (Button) findViewById(R.id.btnMoreApps);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnRepost:
                if (isReadStorageAllowed()) {
                    if (isVideo.equals("video"))
                        repostInstaPostVideo();
                    else
                        repostInstaPost();
                } else {
                    requestStoragePermission();
                }

                break;
            case R.id.btnSave:
                imageAndVideoSave();
                break;
            case R.id.btnNoAds:
                if (isReadStorageAllowed()) {
                    startActivity(new Intent(ActivityRepostSave.this, ActivityNoAds.class));
                } else {
                    requestStoragePermission();
                }
                break;
            case R.id.btnMoreApps:

                if (isReadStorageAllowed()) {
                    startActivity(new Intent(ActivityRepostSave.this, ActivityMoreApps.class));
                } else {
                    requestStoragePermission();
                }
                break;
        }
    }

    private void imageAndVideoSave() {
        if (isReadStorageAllowed()) {
            if (isVideo.equals("video")) {
                final String fileName = "Video" + number + ".mp4";
                final String storagePath = Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name) + "/Videos";
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Utility.storeVideo(VideoLink, fileName, storagePath);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                Toast.makeText(ActivityRepostSave.this, "This video is saved in internal storage", Toast.LENGTH_SHORT).show();

            } else {

                savePost();
                Toast.makeText(ActivityRepostSave.this, "This Image is saved in internal storage", Toast.LENGTH_SHORT).show();

            }
        } else {
            requestStoragePermission();
        }
    }
    //
    //

    private void savePost() {
        final Bitmap finalBitmap = Utility.getBitmapFromURL(PostLink);
        final File output = new File(Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name) + "/Images" + "/images" + number + ".jpg");

        if (!output.exists())
            output.mkdirs();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Utility.SaveImage(output.getAbsolutePath(), finalBitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public boolean isReadStorageAllowed() {
        int result = ContextCompat.checkSelfPermission(ActivityRepostSave.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(ActivityRepostSave.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    private void repostInstaPost() {
        Bitmap bitmap = null;
        try {
            bitmap = Utility.getBitmapFromURL(PostLink);
        } catch (Exception e) {
        }

        String pathofBmp = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
        Uri bmpUri = Uri.parse(pathofBmp);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share Image"));
    }

    private void repostInstaPostVideo() {
        final String fileName = "Video.mp4";
        final String storagePath = Environment.getExternalStorageDirectory().toString() + "/" + getString(R.string.app_name) + "/Videos";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Utility.storeVideo(VideoLink, fileName, storagePath);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        File media = new File(storagePath, fileName);
        Uri uri = Uri.fromFile(media);

        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("video/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(shareIntent, "Share Video"));
    }
}
