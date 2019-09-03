package com.boltec.gbox3d.exam02j2kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.test_textView)).setText( HelloKtKt.helloMessage("gbox3d") );

        HelloKtKt.helloMessageByKotlin(this,"chokuk");

        Log.d("exam02",HelloKtKt.helloMsg("gbox3d"));


    }
}
