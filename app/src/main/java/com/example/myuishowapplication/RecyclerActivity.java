package com.example.myuishowapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView ryV = findViewById(R.id.rv);

        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 40;i++){
            DataBean bean = new DataBean(i, "这是第"+i+"个！");
            list.add(bean);
        }

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list);
        ryV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ryV.setAdapter(adapter);
//        ryV.setLayoutManager(new LinearLayoutManager(this));
        ryV.setLayoutManager(new GridLayoutManager(this, 2));
    }
}