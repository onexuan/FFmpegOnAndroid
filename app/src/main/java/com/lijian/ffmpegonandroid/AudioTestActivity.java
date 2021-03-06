package com.lijian.ffmpegonandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.lijian.videoplayer.tester.AudioCaptureTester;
import com.lijian.videoplayer.tester.AudioCodecTester;
import com.lijian.videoplayer.tester.AudioPlayerTester;
import com.lijian.videoplayer.tester.NativeAudioTester;
import com.lijian.videoplayer.tester.Tester;

/**
 * Created by lijian on 2017/10/26.
 */

public class AudioTestActivity extends AppCompatActivity {
    private Spinner mTestSpinner;
    private Tester mTester;

    public static final String[] TEST_PROGRAM_ARRAY = {
            "录制 wav 文件",
            "播放 wav 文件",
            "OpenSL ES 录制",
            "OpenSL ES 播放",
            "音频编解码"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_audio);

        mTestSpinner = (Spinner) findViewById(R.id.TestSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TEST_PROGRAM_ARRAY);
        mTestSpinner.setAdapter(adapter);
    }

    public void onClickStartTest(View v) {
        switch (mTestSpinner.getSelectedItemPosition()) {
            case 0:
                mTester = new AudioCaptureTester();
                break;
            case 1:
                mTester = new AudioPlayerTester();
                break;
            case 2:
                mTester = new NativeAudioTester(true);
                break;
            case 3:
                mTester = new NativeAudioTester(false);
                break;
            case 4:
                mTester = new AudioCodecTester();
                break;
            default:
                break;
        }
        if (mTester != null) {
            mTester.startTesting();
            Toast.makeText(this, "Start Testing !", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickStopTest(View v) {
        if (mTester != null) {
            mTester.stopTesting();
            Toast.makeText(this, "Stop Testing !", Toast.LENGTH_SHORT).show();
        }
    }
}
