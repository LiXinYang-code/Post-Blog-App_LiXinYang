package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

public class CommentsActivity extends AppCompatActivity {

    private Button commentFin;
    private EditText comment_field;
    private ImageView comment_post_btn;
    private String blog_post_id;
    public static String commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        getSupportActionBar().setTitle("Comments");

        blog_post_id = getIntent().getStringExtra("blog_post_id");
        comment_field = findViewById(R.id.comment_field);
        comment_post_btn = findViewById(R.id.comment_post_btn);
        comment_post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String comment_message = comment_field.getText().toString();

                if (!comment_message.isEmpty()){

                    /**
                     * need to finish by mongodb
                     * to replace the original firebase service
                     */

                    Toast.makeText(CommentsActivity.this,"you have successful add your comments",Toast.LENGTH_LONG).show();
                    Intent notifiIntent = new Intent(CommentsActivity.this,MainActivity.class);
                    startActivity(notifiIntent);

                }

            }
        });

        //save the comments for sending to other activity
        commentFin = findViewById(R.id.comment_finish_btn);
        commentFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                commentText =comment_field.getText().toString();
                Toast.makeText(CommentsActivity.this,"Saved the comments successfully",Toast.LENGTH_LONG).show();

            }
        });

    }
}