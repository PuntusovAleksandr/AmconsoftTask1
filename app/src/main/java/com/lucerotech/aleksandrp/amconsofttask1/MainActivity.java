package com.lucerotech.aleksandrp.amconsofttask1;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.lucerotech.aleksandrp.amconsofttask1.adapter.RecyclerAdapterImages;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mUriList;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.rv_images)
    RecyclerView mRecyclerView;

    @Bind(R.id.bt_in_work)
    Button mButton;

    @Bind(R.id.scroll)
    ScrollView mScroll;

    private ArrayList<Uri> mListUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setLocaleApp();

        mUriList = getListUrl();

        initToolbar();
        initUi();
    }

    private void setLocaleApp() {
        Locale locale = new Locale("uk");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * init ui elements
     */
    private void initUi() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerAdapterImages adapterImages = new RecyclerAdapterImages(mUriList, this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapterImages);

        mScroll.fullScroll(ScrollView.FOCUS_UP);
        mScroll.smoothScrollTo(0,0);
    }


    /**
     * init mToolbar
     */
    private void initToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    /**
     * get list url icons
     *
     * @return
     */
    public ArrayList<String> getListUrl() {
        String[] list = getResources().getStringArray(R.array.list_url);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            arrayList.add(s);
        }
        return arrayList;
    }

    /**
     * listener on click button
     */
    @OnClick(R.id.bt_in_work)
    public void clickInWork() {
        Snackbar.make(mButton, mButton.getText().toString(), Snackbar.LENGTH_SHORT).show();
    }
}
