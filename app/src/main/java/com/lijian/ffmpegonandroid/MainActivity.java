package com.lijian.ffmpegonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSimpleVideoPlay;
    private Button mSimpleAudioPlay;
    private Button mAudioTest;
    private Button mCameraTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSimpleVideoPlay = (Button) findViewById(R.id.simple_video_player);
        mSimpleAudioPlay = (Button) findViewById(R.id.simple_audio_player);
        mAudioTest = (Button) findViewById(R.id.simple_audio_test);
        mCameraTest = (Button) findViewById(R.id.simple_camera_test);
        mSimpleVideoPlay.setOnClickListener(this);
        mSimpleAudioPlay.setOnClickListener(this);
        mAudioTest.setOnClickListener(this);
        mCameraTest.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple_video_player:
                gotoSimpleVideoPlayer();
                break;
            case R.id.simple_audio_player:
                gotoSimpleAudioPlayer();
                break;
            case R.id.simple_audio_test:
                gotoAudioTestPlayer();
                break;
            case R.id.simple_camera_test:
                gotoCameraTest();
                break;
        }
    }

    private void gotoCameraTest() {
        Intent intent = new Intent(this, SimpleCameraActivity.class);
        startActivity(intent);
    }

    private void gotoAudioTestPlayer() {
        Intent intent = new Intent(this, AudioTestActivity.class);
        startActivity(intent);
    }

    private void gotoSimpleAudioPlayer() {
        Intent intent = new Intent(this, SimpleAudioPlayerActivity.class);
        startActivity(intent);
    }

    private void gotoSimpleVideoPlayer() {
        Intent intent = new Intent(this, SimpleVideoPlayerActivity.class);
        startActivity(intent);
    }
}
