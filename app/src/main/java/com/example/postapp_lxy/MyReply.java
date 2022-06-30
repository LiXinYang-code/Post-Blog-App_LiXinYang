package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyReply extends AppCompatActivity {

    private TextView myReplyUserName;
    private TextView myReplyContentShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reply);
        getSupportActionBar().setTitle("My Reply");

        /**
         * update the user name
         */
        myReplyUserName = findViewById(R.id.myReply_userName);
        myReplyUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myReplyUserName.setText(SetupActivity.userName);

            }
        });

        /**
         * update the content of reply
         */
        myReplyContentShow = findViewById(R.id.myReply_content_show);
        myReplyContentShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myReplyContentShow.setText(ReplyContent.saveReplyContent);

            }
        });


    }
}