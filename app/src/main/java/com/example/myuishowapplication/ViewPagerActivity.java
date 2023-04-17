package com.example.myuishowapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
private List<String> str_datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        str_datas.add("我");
        str_datas.add("是");
        str_datas.add("食");
        str_datas.add("雪");
        str_datas.add("汉");

        ViewPager2 vp2 = findViewById(R.id.view_pager2);
        vp2.setAdapter(new PagerAdapter(str_datas));

        TabLayout tabs = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabs, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(str_datas.get(position));
            }
        }).attach();

    }
}