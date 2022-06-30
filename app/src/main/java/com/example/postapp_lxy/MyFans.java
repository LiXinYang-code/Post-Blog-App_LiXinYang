package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyFans extends AppCompatActivity {

    private TextView fansName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans);
        getSupportActionBar().setTitle("My Fans");

        /**
         * initialize the fans name:
         */
        fansName = findViewById(R.id.myfans_user_name);
        fansName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fansName.setText(SetupActivity.userName);

            }
        });



    }
}