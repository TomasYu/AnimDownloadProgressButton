package com.example.zy1.downloadbutton;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zy1.downloadbutton.Custombutton.AnimButtonLayout;
import com.example.zy1.downloadbutton.Custombutton.AnimDownloadProgressButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AnimDownloadProgressButton mAnimDownloadProgressButton;
    AnimDownloadProgressButton mAnimDownloadProgressButton2;
    AnimButtonLayout mAnimButtonLayout;
    Button mReset;
    TextView mDescription;
    SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReset = (Button) findViewById(R.id.reset);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mDescription = (TextView) findViewById(R.id.description);

        mAnimDownloadProgressButton = (AnimDownloadProgressButton) findViewById(R.id.anim_btn);
        mAnimDownloadProgressButton.setCurrentText("安装");
        mAnimDownloadProgressButton.setTextSize(60f);
        mAnimDownloadProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheButton(R.id.anim_btn);
            }
        });

        mAnimDownloadProgressButton2 = (AnimDownloadProgressButton) findViewById(R.id.anim_btn2);
        mAnimDownloadProgressButton2.setCurrentText("安装");
        mAnimDownloadProgressButton2.setTextSize(60f);
        mAnimDownloadProgressButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheButton(R.id.anim_btn2);
            }
        });

        mAnimButtonLayout = (AnimButtonLayout) findViewById(R.id.anim_btn3);
        mAnimButtonLayout.setCurrentText("安装");
        mAnimButtonLayout.setTextSize(60f);
        mAnimButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheButton(R.id.anim_btn3);
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimDownloadProgressButton.setState(AnimDownloadProgressButton.NORMAL);
                mAnimDownloadProgressButton.setCurrentText("安装");
                mAnimDownloadProgressButton.setProgress(0);
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAnimDownloadProgressButton.setButtonRadius((progress / 100.0f) * mAnimDownloadProgressButton.getHeight() / 2);
                mAnimDownloadProgressButton.postInvalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mDescription.setText(" This is a DownloadProgressButton library with Animation," +
                "you can change radius,textColor,coveredTextColor,BackgroudColor,etc in" +
                " your code or just in xml.\n\n" +
                "The library is open source in github https://github.com/cctanfujun/ProgressRoundButton .\n" +
                "Hope you like it ");
    }

    private void showTheButton(int id) {
        switch (id) {
            case R.id.anim_btn:
                mAnimDownloadProgressButton.setState(AnimDownloadProgressButton.DOWNLOADING);
                mAnimDownloadProgressButton.setProgressText("下载中", mAnimDownloadProgressButton.getProgress() + 8);
                Log.d(TAG, "showTheButton: " + mAnimDownloadProgressButton.getProgress());
                if (mAnimDownloadProgressButton.getProgress() + 10 > 100) {
                    mAnimDownloadProgressButton.setState(AnimDownloadProgressButton.INSTALLING);
                    mAnimDownloadProgressButton.setCurrentText("安装中");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            mAnimDownloadProgressButton.setState(AnimDownloadProgressButton.NORMAL);
                            mAnimDownloadProgressButton.setCurrentText("打开");
                        }
                    }, 2000);   //2秒
                }
                break;
            case R.id.anim_btn2:
                mAnimDownloadProgressButton2.setState(AnimDownloadProgressButton.DOWNLOADING);
                mAnimDownloadProgressButton2.setProgressText("下载中", mAnimDownloadProgressButton2.getProgress() + 8);
                Log.d(TAG, "showTheButton: " + mAnimDownloadProgressButton2.getProgress());
                if (mAnimDownloadProgressButton2.getProgress() + 10 > 100) {
                    mAnimDownloadProgressButton2.setState(AnimDownloadProgressButton.INSTALLING);
                    mAnimDownloadProgressButton2.setCurrentText("安装中");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            mAnimDownloadProgressButton2.setState(AnimDownloadProgressButton.NORMAL);
                            mAnimDownloadProgressButton2.setCurrentText("打开");
                        }
                    }, 2000);   //2秒
                }
                break;
            case R.id.anim_btn3:
                mAnimButtonLayout.setState(AnimDownloadProgressButton.DOWNLOADING);
                mAnimButtonLayout.setProgressText("下载中", mAnimButtonLayout.getProgress() + 8);
                Log.d(TAG, "showTheButton: " + mAnimButtonLayout.getProgress());
                if (mAnimButtonLayout.getProgress() + 10 > 100) {
                    mAnimButtonLayout.setState(AnimDownloadProgressButton.INSTALLING);
                    mAnimButtonLayout.setCurrentText("安装中");
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            mAnimButtonLayout.setState(AnimDownloadProgressButton.NORMAL);
                            mAnimButtonLayout.setCurrentText("打开");
                        }
                    }, 2000);   //2秒
                }
                break;
        }


    }


}
