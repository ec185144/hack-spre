package com.ncr.hackspre;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Hide action bar
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        ActionBar b = getSupportActionBar();
        b.hide();
    }

    // called when user taps scan button
    public void onScan(View view) {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }

    // called when user taps start order button
    public void onStartOrder(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}