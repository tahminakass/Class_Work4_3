package com.example.class_work4_3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.class_work4_3.databinding.ItemMainBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<MainModel> mainModels;
    OnItemClick onItemClick;

    public MainAdapter(ArrayList<MainModel> mainModels, OnItemClick onItemClick) {
        this.mainModels = mainModels;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(mainModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

class MainViewHolder extends RecyclerView.ViewHolder {

    ItemMainBinding binding;

    public MainViewHolder(@NonNull ItemMainBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(MainModel mainModel) {
        Glide.with(binding.imgMain).load(mainModel.getImage()).into(binding.imgMain);
        binding.tvName.setText(mainModel.getName());
    }
}
