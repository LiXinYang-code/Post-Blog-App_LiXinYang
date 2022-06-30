package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class myFollow extends AppCompatActivity {

    private TextView followsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_follow);
        getSupportActionBar().setTitle("My Follows");

        followsName = findViewById(R.id.myfollow_userName);
        followsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                followsName.setText(SetupActivity.userName);

            }
        });



    }
}