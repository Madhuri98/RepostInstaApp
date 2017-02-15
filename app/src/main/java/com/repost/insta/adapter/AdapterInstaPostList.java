package com.repost.insta.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.repost.insta.R;
import com.repost.insta.activity.ActivityRepostSave;
import com.repost.insta.constant.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 9Brainz on 2/8/2017.
 */

public class AdapterInstaPostList extends RecyclerView.Adapter<AdapterInstaPostList.ViewHolder> {
    private List<String> listPofileImage, listPostImage, listProfileName, listInstaName, listPostDescription, listIsVideo, listPostVideoLink;
    private Context context;
    private Random mRandom = new Random();

    public AdapterInstaPostList(Context context, List<String> listPofileImage, List<String> listPostImage, List<String> listProfileName, List<String> listInstaName, List<String> listPostDescription, List<String> listIsVideo, ArrayList<String> listPostVideoLink) {
        this.listPofileImage = listPofileImage;
        this.listPostImage = listPostImage;
        this.listInstaName = listInstaName;
        this.listProfileName = listProfileName;
        this.listPostVideoLink = listPostVideoLink;
        this.listIsVideo = listIsVideo;
        this.listPostDescription = listPostDescription;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_post_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvProfileFullName.setText(listProfileName.get(position));
        holder.imgPostPhoto.getLayoutParams().height = getRandomIntInRange(500, 400);


        Picasso.with(context)
                .load(listPostImage.get(position)) //this is optional the image to display while the url image is downloading
                .error(R.drawable.profile)         //this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(holder.imgPostPhoto);


        System.out.println("IsVideo List:::::" + listIsVideo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ActivityRepostSave.class);
                i.putExtra(Constant.KEY_POST_LINK, listPostImage.get(position));
                i.putExtra(Constant.KEY_POST_ISVIDEO, listIsVideo.get(position));
                i.putExtra(Constant.KEY_POST_VIDEOLINK, listPostVideoLink.get(position));
                context.startActivity(i);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dialogBoxLongPress(position);
                return false;
            }
        });
        System.out.println("positionsssssss" + position);
    }

    @Override
    public int getItemCount() {
        return listProfileName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProfileFullName/*, itvProfileInstaName, tvPostMessage*/;
        private ImageView /*imgProfile,*/ imgPostPhoto;

        public ViewHolder(View itemView) {
            super(itemView);

            tvProfileFullName = (TextView) itemView.findViewById(R.id.tvProfileFullName);
//            itvProfileInstaName = (TextView) itemView.findViewById(R.id.itvProfileInstaName);
//            tvPostMessage = (TextView) itemView.findViewById(R.id.tvPostMessage);
//            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            imgPostPhoto = (ImageView) itemView.findViewById(R.id.imgPostPhoto);
        }
    }

    protected int getRandomIntInRange(int max, int min) {
        return mRandom.nextInt((max - min) + min) + min;
    }


    public void dialogBoxLongPress(final int position) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox_delete);

        TextView tvDialogDelete = (TextView) dialog.findViewById(R.id.tvDialogDelete);
        TextView tvDialogAdd = (TextView) dialog.findViewById(R.id.tvDialogAdd);
        dialog.setCancelable(false);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); // for activity use context instead of getActivity()
        Display display = wm.getDefaultDisplay(); // getting the screen size of device
        Point size = new Point();
        display.getSize(size);
        int width = size.x - 20;  // Set your heights

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());

        lp.width = width;

        dialog.getWindow().setAttributes(lp);

        tvDialogDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPostImage.remove(position);
                listIsVideo.remove(position);
                listPofileImage.remove(position);
                listInstaName.remove(position);
                listIsVideo.remove(position);
                listPostDescription.remove(position);
                listPostVideoLink.remove(position);
                notifyItemChanged(position);
            }
        });
        tvDialogAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apppackage = "com.instagram.android";
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(apppackage));
            }
        });

//        if (strtitleRef != "" && strmessageRef != "" && stryesRef != "" && strnoRef != "")
        dialog.show();

    }
}
