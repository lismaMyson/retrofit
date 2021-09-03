package com.example.retrofitexample.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitexample.Model.RetrofitListModel;
import com.example.retrofitexample.R;

import java.util.ArrayList;
import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.RetrofitListViewHolder> {
    Context context;
    List<RetrofitListModel> modelList = new ArrayList<>();

    public RetrofitAdapter(Context context, List<RetrofitListModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void UpdateRetrofitList(List<RetrofitListModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RetrofitAdapter.RetrofitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.retrofit_list, parent, false);
        return new RetrofitListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RetrofitAdapter.RetrofitListViewHolder holder, int position) {
        holder.tvName.setText(modelList.get(position).getCharacterName());
        holder.tvRealName.setText(modelList.get(position).getRealName());
        holder.tvTeam.setText(modelList.get(position).getTeam());
        holder.tvFirstAppearance.setText(modelList.get(position).getFirstAppearance().toString());
        holder.tvCreatedBy.setText(modelList.get(position).getCreatedBy());
        holder.tvPublisher.setText(modelList.get(position).getPublisher());
        holder.tvBio.setText(modelList.get(position).getBio());
        Glide.with(context).load(modelList.get(position).getCharacterImage()).into(holder.imvCharacterImage);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class RetrofitListViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvRealName;
        TextView tvTeam;
        TextView tvFirstAppearance;
        TextView tvCreatedBy;
        TextView tvPublisher;
        TextView tvBio;
        ImageView imvCharacterImage;

        public RetrofitListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvRealName = itemView.findViewById(R.id.tvRealName);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            tvFirstAppearance = itemView.findViewById(R.id.tvFirstAppearance);
            tvCreatedBy = itemView.findViewById(R.id.tvCreatedBy);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            tvBio = itemView.findViewById(R.id.tvBio);
            imvCharacterImage = itemView.findViewById(R.id.imvCharacterImage);
        }
    }
}


