package com.example.myquiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private ListActivity activity;
    private List<UserModel> scoreList;

    public ListAdapter(ListActivity activity, List<UserModel> scoreList) {
        this.activity = activity;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText("Név: "+scoreList.get(position).getUsername());
        holder.score.setText("Pontszám: "+scoreList.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.title_text);
            score = itemView.findViewById(R.id.desc_text);
        }
    }

}
