package com.anas.firebasetiktok;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adapter_Video extends FirebaseRecyclerAdapter<Model_Video,Adapter_Video.Video_ViewHolder> {

    public Adapter_Video(@NonNull FirebaseRecyclerOptions<Model_Video> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Video_ViewHolder holder, int position, @NonNull Model_Video model) {
        holder.setData(model);
    }

    @NonNull
    @Override
    public Video_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_single,parent,false);
        return new Video_ViewHolder(view);
    }

    public class Video_ViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView_single;
        TextView txtTitle_single,txtDesc_single;
        ProgressBar progressBar_single;

        public Video_ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView_single = itemView.findViewById(R.id.videoView_single);
            txtDesc_single = itemView.findViewById(R.id.txtDesc_single);
            txtTitle_single = itemView.findViewById(R.id.txtTitle_single);
            progressBar_single = itemView.findViewById(R.id.progressBar_single);

        }

        void setData(Model_Video model_obj){
            videoView_single.setVideoPath(model_obj.getUrl());
            txtTitle_single.setText(model_obj.getTitle());
            txtDesc_single.setText(model_obj.getDesc());

            videoView_single.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar_single.setVisibility(View.GONE);
                    mp.start();
                }
            });

            videoView_single.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
