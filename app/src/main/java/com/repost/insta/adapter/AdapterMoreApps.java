package com.repost.insta.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.repost.insta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 9Brainz on 2/9/2017.
 */

public class AdapterMoreApps extends RecyclerView.Adapter<AdapterMoreApps.ViewHolder2> {
    private List<String> listPofileImage, listPostImage, listProfileName, listInstaName, listPostDescription;
    private Context context;

    public AdapterMoreApps(Context con,ArrayList<String> list) {
        context =con;
        Toast.makeText(context, "Adapter:"+list, Toast.LENGTH_SHORT).show();
        listInstaName = list;
    }



    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_more_apps, parent, false);
        Toast.makeText(context, "view:::", Toast.LENGTH_SHORT).show();
        return  new AdapterMoreApps.ViewHolder2(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
        holder.tvMoreAppsVersion.setText("version 3.2");
        holder.tvMoreAppsName.setText("MarioGame");
        holder.imgMoreAppsPic.setImageResource(R.drawable.profile);
    }

    @Override
    public int getItemCount() {
        return listInstaName.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView tvMoreAppsVersion, tvMoreAppsName;
        private ImageView imgMoreAppsPic;

        public ViewHolder2(View itemView) {
            super(itemView);
            tvMoreAppsVersion = (TextView) itemView.findViewById(R.id.tvMoreAppsVersion);
            tvMoreAppsName = (TextView) itemView.findViewById(R.id.tvMoreAppsName);
            imgMoreAppsPic = (ImageView) itemView.findViewById(R.id.imgMoreAppsPic);
        }
    }
}