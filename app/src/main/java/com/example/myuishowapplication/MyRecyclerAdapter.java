package com.example.myuishowapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private List<DataBean> datas;

    public MyRecyclerAdapter(List<DataBean> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.index.setText(String.valueOf(datas.get(position).getInt_num()));
        holder.description.setText(datas.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.datas.size();
    }

    //    private List<DataBean> datas;
//
//    public MyRecyclerAdapter(List<DataBean> datas) {
//        this.datas = datas;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.index.setText(String.valueOf(datas.get(position).getInt_num()));
//        holder.description.setText(datas.get(position).getDescription());
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.datas.size();
//    }
//
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView index;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.text_index);
            description = itemView.findViewById(R.id.text_description);
            initClick();
        }
        public void initClick() {
            index.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "你点击了序号"+((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            description.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "你点击了描述", Toast.LENGTH_SHORT).show();
                }
            });
        }
//        TextView index;
//        TextView description;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            index = itemView.findViewById(R.id.text_index);
//            description = itemView.findViewById(R.id.text_description);
//            initClick();
//        }
//
//        public void initClick() {
//            index.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "你点击了序号"+((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
//            description.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "你点击了描述", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
    }
}
