package com.example.rctviedoplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPlayerActivity extends Activity
        implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener,
                         MediaPlayer.OnPreparedListener
{

    private MediaController mMediaController;
    private static final String TAG = "player";
    private TextView mLoading = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        String path = intent.getStringExtra("PATH");

        VideoView view = (VideoView) findViewById(R.id.player);
        mLoading = (TextView) findViewById(R.id.loading);

        mMediaController = new MediaController(this);
        view.setMediaController(mMediaController);
        view.setOnCompletionListener(this);
        view.setOnErrorListener(this);
        view.setOnPreparedListener(this);

        if (!TextUtils.isEmpty(path)) {
            view.setVideoURI(Uri.parse(path));
            view.start();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.finish();
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        mLoading.setText("加载视频出错");
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mLoading.setVisibility(View.GONE);
    }
}
