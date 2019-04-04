package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button PlayButton;
    private SeekBar positionBar, volumebar;
    private TextView elapsedTimeLabel, remainingTimeLabel;
    private MediaPlayer mediaPlayer;
    private int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton = (Button) findViewById(R.id.playButton);
        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.files);
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f, 0.5f);
        totalTime = mediaPlayer.getDuration();

        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser)
                {
                    mediaPlayer.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
