package com.repost.insta.activity;

import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onesignal.OneSignal;
import com.repost.insta.R;
import com.repost.insta.adapter.AdapterInstaPostList;
import com.repost.insta.constant.Constant;
import com.repost.insta.database.DatabaseAccess;
import com.repost.insta.interfaces.RequestInterface;
import com.repost.insta.model.database.DatabaseListPOJO;
import com.repost.insta.model.media.Success;
import com.repost.insta.model.media_authhorized.ItemsBean;
import com.repost.insta.model.media_authhorized.MediaAuthorizedSucess;
import com.repost.insta.utill.SessionManager;
import com.repost.insta.utill.SpacesItemDecoration;
import com.squareup.picasso.Picasso;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView reclerViewPostList;
    private ArrayList<String> listPofileImage, listPostImage, listProfileName, listInstaName, listPostDescription, listMediaId, listType, listPostVideoLink;
    private SessionManager sm;
    private ClipboardManager clipboardManager;
    private CircleImageView imgDrawProfileImage;
    private Toolbar toolbar;
    private DatabaseListPOJO databaseListPOJO;
    private AdapterInstaPostList adapterInstaPostList;
    private static final long RIPPLE_DURATION = 250;
    private FrameLayout root;
    private ImageView imgInsta, imgDrawer;
    private int STORAGE_PERMISSION_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OneSignal.startInit(this).init();
        setContentView(R.layout.activity_home_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestStoragePermission();
        getWidgetReference();
        eventHandler();
        initializeListFromDatabase();
        startDrawerView();
//        getData();
    }

    private void eventHandler() {
        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagram();
            }
        });

    }


    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    private void startDrawerView() {
        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);

        root.addView(guillotineMenu);

        /*new GuillotineAnimation.GuillotineBuilder(guillotineMenu,guillotineMenu.findViewById(R.id.content_hamburger),contentHambuger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();*/
        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), imgDrawer)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    private void initializeListFromDatabase() {
        databaseListPOJO = dbConncection(MainActivity.this);
        for (int i = 0; i < databaseListPOJO.getDatabasePOJOList().size(); i++) {
            listMediaId.add(databaseListPOJO.getDatabasePOJOList().get(i).getMediaID());
            listPostImage.add(databaseListPOJO.getDatabasePOJOList().get(i).getThumb());
            listPofileImage.add(databaseListPOJO.getDatabasePOJOList().get(i).getAuthorPhoto());
            listProfileName.add(databaseListPOJO.getDatabasePOJOList().get(i).getAuthorFullname());
            listInstaName.add(databaseListPOJO.getDatabasePOJOList().get(i).getAuthor());
            listPostDescription.add(databaseListPOJO.getDatabasePOJOList().get(i).getDescription());
            listType.add(databaseListPOJO.getDatabasePOJOList().get(i).getIsVideo());
            System.out.println("TYPE :::::: " + listType);
            listPostVideoLink.add(databaseListPOJO.getDatabasePOJOList().get(i).getVideo());
//            System.out.println("VIDEOOO DATA:::::: " + video);
        }
        adapterInstaPostList = new AdapterInstaPostList(MainActivity.this,
                listPofileImage,
                listPostImage,
                listProfileName,
                listInstaName,
                listPostDescription, listType, listPostVideoLink);
        reclerViewPostList.setAdapter(adapterInstaPostList);
    }

    private DatabaseListPOJO dbConncection(Context context) {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        DatabaseListPOJO pojo = databaseAccess.getData(Constant.TABLE_NM);

//        System.out.println("DATABASE DATA :::: " + pojo.getDatabasePOJOList().get(0).getAuthor());
        databaseAccess.close();
        return pojo;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (clipboardManager.getText() != null && clipboardManager.getText().toString().startsWith("https://www.instagram.com"))
        getData();
    }

    private void getWidgetReference() {
        root = (FrameLayout) findViewById(R.id.top_parent);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        reclerViewPostList = (RecyclerView) findViewById(R.id.reclerViewPostList);
        reclerViewPostList.setLayoutManager(layoutManager);
        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
        reclerViewPostList.addItemDecoration(decoration);

        imgDrawer = (ImageView) findViewById(R.id.imgDrawer);
        imgInsta = (ImageView) findViewById(R.id.imgInsta);


        sm = new SessionManager(MainActivity.this);
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboardManager.setText(null);
        listPofileImage = new ArrayList<>();// sm.getSet(Constant.KEY_PROFILE_PICTURE);
        listPostImage = new ArrayList<>();//sm.getSet(Constant.KEY_PROFILE_PICTURE);
        listProfileName = new ArrayList<>();//sm.getSet(Constant.KEY_PROFILE_PICTURE);
        listInstaName = new ArrayList<>();//sm.getSet(Constant.KEY_PROFILE_PICTURE);
        listPostDescription = new ArrayList<>();//sm.getSet(Constant.KEY_PROFILE_PICTURE);
        listMediaId = new ArrayList<>();
        listType = new ArrayList<>();
        listPostVideoLink = new ArrayList<>();


        if (!sm.getUserProfilePic().equals("")) {
            Picasso.with(MainActivity.this)
                    .load(sm.getUserProfilePic()) //this is optional the image to display while the url image is downloading
                    .error(R.drawable.profile)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                    .into(imgDrawProfileImage);
        }
    }

    private void getData() {
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String copy_url = "?url=" + clipboardManager.getText().toString()/*"https://www.instagram.com/p/BQNZ6EWl-7D/"*/;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        final Call<Success> successCall = requestInterface.getData(copy_url);
        successCall.enqueue(new Callback<Success>() {
            @Override
            public void onResponse(Call<Success> call, Response<Success> response) {
                if (response.isSuccessful()) {
                    getPost(response.body().getAuthor_name(), response.body().getMedia_id());
                }
            }

            @Override
            public void onFailure(Call<Success> call, Throwable t) {
                System.out.println("Something went Wrong......");
                Toast.makeText(MainActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPost(String author_nm, final String mediaId) {
        final String url2 = author_nm + "/media/?id=\\u005c\\u0022" + mediaId + "\u005c\u0022";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        Call<MediaAuthorizedSucess> listSuccessCall = requestInterface.getPost(url2);
        listSuccessCall.enqueue(new Callback<MediaAuthorizedSucess>() {
            @Override
            public void onResponse(Call<MediaAuthorizedSucess> call, Response<MediaAuthorizedSucess> response) {
                if (response.isSuccessful() && response.body().getStatus().equals("ok")) {

                    ItemsBean itemsBean = response.body().getItems().get(0);
                    String v, author = null, authorFullname = null, authorPhoto = null, description = null;

                    if (itemsBean.getCaption() != null) {
                        author = itemsBean.getCaption().getFrom().getUsername();
                        authorFullname = itemsBean.getCaption().getFrom().getFullName();
                        authorPhoto = itemsBean.getCaption().getFrom().getProfilePicture();
                        description = itemsBean.getCaption().getText();
                    }
                    String photo = itemsBean.getImages().getStandardResolution().getUrl();

                    String isVideo = itemsBean.getType();
                    System.out.println("isVideo ::: " + isVideo);
                    String thumb = itemsBean.getImages().getStandardResolution().getUrl();
//                    v = itemsBean.get(0).getVideos().getStandardResolution().getUrl();
//                    System.out.println("VIDEOOO :::::::::::::::::: " + v);

                    databaseListPOJO = dbConncection(MainActivity.this);

                    boolean isMedia = false;
                    for (int i = 0; i < databaseListPOJO.getDatabasePOJOList().size(); i++)
                        listMediaId.add(databaseListPOJO.getDatabasePOJOList().get(i).getMediaID());

                    for (int i = 0; i < listMediaId.size(); i++) {
                        if (listMediaId.get(i).equals(mediaId)) {
                            isMedia = true;
                            break;
                        }

                    }
                    if (!isMedia) {

                        if (isVideo.equals("video"))
                            v = itemsBean.getVideos().getStandardResolution().getUrl();
                        else
                            v = null;

                        insertDataIntoTable(author, description, photo, authorFullname, authorPhoto, v, isVideo, thumb);

                        listPostImage.add(thumb);
                        listPofileImage.add(authorPhoto);
                        listProfileName.add(authorFullname);
                        listInstaName.add(author);
                        listPostDescription.add(description);
                        listType.add(itemsBean.getType());
                        listPostVideoLink.add(v);

                    }

                    adapterInstaPostList = new AdapterInstaPostList(MainActivity.this,
                            listPofileImage,
                            listPostImage,
                            listProfileName,
                            listInstaName,
                            listPostDescription,
                            listType,
                            listPostVideoLink);

                    reclerViewPostList.setAdapter(adapterInstaPostList);
                    adapterInstaPostList.notifyDataSetChanged();
                }

            }

            private void insertDataIntoTable(String author, String description, String photo, String authorFullname, String authorPhoto, String video, String isVideo, String thumb) {
                ContentValues cv = new ContentValues();
                cv.put(Constant.KEY_AUTHOR, author);
                cv.put(Constant.KEY_DESCRIPTION, description);
                cv.put(Constant.KEY_PHOTO, photo);
                cv.put(Constant.KEY_MEDIAID, mediaId);
                cv.put(Constant.KEY_AUTHORFULLNAME, authorFullname);
                cv.put(Constant.KEY_AUTHORPHOTO, authorPhoto);
                cv.put(Constant.KEY_VIDEO, video);
                cv.put(Constant.KEY_isVideo, isVideo);
                cv.put(Constant.KEY_THUMB, thumb);
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(MainActivity.this);
                databaseAccess.insertSingleRecord(Constant.TABLE_NM, cv);
            }

            @Override
            public void onFailure(Call<MediaAuthorizedSucess> call, Throwable t) {

            }
        });
    }

    private void openInstagram() {
        String apppackage = "com.instagram.android";
        startActivity(getPackageManager().getLaunchIntentForPackage(apppackage));
    }


}
