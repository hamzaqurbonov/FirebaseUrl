package com.example.firebaseurl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseurl.databinding.ReelDesgnBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder> {
    Context context;
    ArrayList<Model> modelArrayList = new ArrayList<>();



//    @SuppressLint("MissingInflatedId")


    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_desgn,parent,false);

        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());

//        holder.binding.name.setText(modelArrayList.get(position).getName());
//        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());

        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{

        ReelDesgnBinding binding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReelDesgnBinding.bind(itemView);
        }
    }
}
