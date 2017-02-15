package com.repost.insta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.repost.insta.R;
import com.repost.insta.adapter.AdapterMoreApps;

import java.util.ArrayList;

/**
 * Created by 9Brainz on 2/9/2017.
 */


public class ActivityMoreApps extends AppCompatActivity {

    private RecyclerView recycleMoreAppsView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterMoreApps adapterMoreApps;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_apps);
        getWidgetReferences();
        System.out.println("hello");
    }

    private void getWidgetReferences() {
        recycleMoreAppsView = (RecyclerView) findViewById(R.id.recycleMoreAppsView);
        layoutManager = new LinearLayoutManager(ActivityMoreApps.this);
        recycleMoreAppsView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add("askdw;lada");
        list.add("askdw;lada");
        list.add("askdw;lada");

        adapterMoreApps = new AdapterMoreApps(this,list);
        recycleMoreAppsView.setAdapter(adapterMoreApps);
    }
}
