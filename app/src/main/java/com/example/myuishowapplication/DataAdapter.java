package com.example.myuishowapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends ArrayAdapter<DataBean> {
    private int itemID;

    public DataAdapter(Context context, int ItemLayoutResID, List<DataBean> datas) {
        super(context, ItemLayoutResID, datas);
        itemID = ItemLayoutResID;
    }

        @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataBean dataBean = getItem(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(itemID, parent, false);
            holder = new ViewHolder();
            holder.index = view.findViewById(R.id.text_index);
            holder.description = view.findViewById(R.id.text_description);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        holder.index.setText(String.valueOf(dataBean.getInt_num()));
        holder.description.setText(dataBean.getDescription());
        return view;
    }

    class ViewHolder {
        TextView index;
        TextView description;
    }
}
