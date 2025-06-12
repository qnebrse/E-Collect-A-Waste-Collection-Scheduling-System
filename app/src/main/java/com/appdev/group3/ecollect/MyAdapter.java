package com.appdev.group3.ecollect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList msg_id;

    public MyAdapter(Context context, ArrayList msg_id) {
        this.context = context;
        this.msg_id = msg_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.msg_id.setText(String.valueOf(msg_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return msg_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView msg_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg_id = itemView.findViewById(R.id.textname);
        }
    }
}