package com.example.myuishowapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ListView list_view = findViewById(R.id.test_list_view);

//        Integer[] arr = new Integer[40];
//        for (int i = 0;i < 40;i++)
//            arr[i] = i+1;
//
//        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
//        list_view.setAdapter(adapter);
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 40;i++){
            DataBean bean = new DataBean(i, "这是第"+i+"个！");
            list.add(bean);
        }

        DataAdapter adapter = new DataAdapter(this, R.layout.item_layout, list);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataBean bean = list.get(i);
                Toast.makeText(TestActivity.this, "你点击了第"+bean.getInt_num()+"个item!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}