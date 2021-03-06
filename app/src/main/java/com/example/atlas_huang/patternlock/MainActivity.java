package com.example.atlas_huang.patternlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.atlas_huang.patternlock.patternlock.PatternConfrimActivity;
import com.example.atlas_huang.patternlock.patternlock.PatternSetActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mBtnSetCkcButton = (Button) findViewById(R.id.buttonCkcPattern);
        mBtnSetCkcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity(PatternConfrimActivity.class);
            }
        });


        Button mBtnSetPattern = (Button) findViewById(R.id.buttonSetPattern);
        mBtnSetPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity(PatternSetActivity.class);
            }
        });

        Button mBtnSetPin = (Button) findViewById(R.id.buttonSetPin);
        mBtnSetPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity(SampleSetPinActivity.class);
            }
        });

        Button mBtnSetFingerPrint = (Button) findViewById(R.id.buttonSetFingerPrint);
        mBtnSetFingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity(SampleSetFingerPrintActivity.class);
            }
        });

    }

    private void showActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
