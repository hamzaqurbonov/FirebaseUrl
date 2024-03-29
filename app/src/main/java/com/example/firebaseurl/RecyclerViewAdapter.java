package com.example.firebaseurl;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final String[] videoIds;
    private final Lifecycle lifecycle;

    RecyclerViewAdapter(String[] videoIds, Lifecycle lifecycle) {
        this.videoIds = videoIds;
        this.lifecycle = lifecycle;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
//        YouTubePlayerView youTubePlayerView1 = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.null_item, parent, false);

//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.null_item, parent, false);

        lifecycle.addObserver(youTubePlayerView);

        return new ViewHolder(youTubePlayerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.loadVideo(videoIds[position]);

//        viewHolder.expanded = !viewHolder.expanded;
        Log.d("demo3",videoIds[position]);

    }

    @Override
    public int getItemCount() {
        return videoIds.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final YouTubePlayerView youTubePlayerView;
        public boolean expanded;
        private YouTubePlayer youTubePlayer;
        private String currentVideoId;

        ViewHolder(YouTubePlayerView playerView) {
            super(playerView);
            youTubePlayerView = playerView;

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer;
                    youTubePlayer.loadVideo(currentVideoId, 0);
                }

//                @Override
//                public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state) {
//                    playVideoAtSelection();
//
//                    // this method is called if video has ended,
//                    super.onStateChange(youTubePlayer, state);
//
//                }
            });
        }

        void loadVideo(String videoId) {
            currentVideoId = videoId;

//            if (youTubePlayer == null)
                return;

//            youTubePlayer.cueVideo(videoId, 0);
        }

        private void playVideoAtSelection() {
            if (!(youTubePlayer == null)) {
                youTubePlayer.play();

            }
        }
    }
}