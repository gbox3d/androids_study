package com.boltec.gbox3d.exam0basic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    final static String TAG = "exam0";

    MediaPlayer m_PlayerNinja;
    MediaPlayer m_LoopTest;

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.button_test1:
                    Log.d(TAG,"click btn1");
                    ((TextView)findViewById(R.id.out_text)).setText("good nochiwa");
                    m_PlayerNinja.start();
                    break;
                case R.id.button_test2:
                    ((TextView)findViewById(R.id.out_text)).setText("hi~");
                    m_PlayerNinja.stop();

                    //다시 연주를 위한 준비
                    m_PlayerNinja.prepare();

                    //m_PlayerNinja.release();

                    break;
                case R.id.button_loop_test:
                    if(m_LoopTest.isPlaying() == false) {

                        m_LoopTest.start();
                    }
                    else {
                        m_LoopTest.stop();
                        m_LoopTest.prepare();

                    }

                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test _tt =  new test();

        _tt.testfun();

        m_PlayerNinja =  MediaPlayer.create(this,R.raw.ninja);
        m_LoopTest = MediaPlayer.create(this,R.raw.fx236);
        m_LoopTest.setLooping(true);

        Log.d("exam0","hello");

        Button btn1 = findViewById(R.id.button_test1);

        btn1.setOnClickListener(this);

        ((Button) findViewById(R.id.button_test2)).setOnClickListener(this);
        ((Button) findViewById(R.id.button_loop_test)).setOnClickListener(this);

    }




}
