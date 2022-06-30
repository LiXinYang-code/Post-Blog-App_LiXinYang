package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.sax.SAXResult;

public class ReplyContent extends AppCompatActivity {

    private TextView replyUserName;
    private TextView replyContent;
    public static String saveReplyContent;
    private Button replyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_content);
        getSupportActionBar().setTitle("My Reply Content");

        replyUserName = findViewById(R.id.myReply_user_name);
        replyUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replyUserName.setText(SetupActivity.userName);

            }
        });

        replyContent = findViewById(R.id.replyContent);
        replyBtn = findViewById(R.id.myReply_btn);
        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //save the contents of reply firstly
                saveReplyContent = replyContent.getText().toString();

                //send to other Reply activity
                Intent sendReply = new Intent(ReplyContent.this,MyReply.class);
                startActivity(sendReply);

            }
        });


    }
}