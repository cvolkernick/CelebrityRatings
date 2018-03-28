package com.example.cvolk.celebrityratings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addCelebrity(View view) {
        Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
        startActivity(intent);
    }
}
