package com.example.postapp_lxy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import io.grpc.Compressor;

public class NewPostActivity extends AppCompatActivity {


    private static final int MAX_LENGTH = 100;
    private ImageView newPostImage;

    private EditText  newPostDesc;
    public static String postDesc;

    private Button newPostBtn;

    private ProgressBar newPostProgress;

    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;

    private File compressedImageFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        getSupportActionBar().setTitle("Add New Post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newPostImage = findViewById(R.id.new_post_image);
        newPostDesc = findViewById(R.id.new_post_desc);
        newPostBtn = findViewById(R.id.post_btn);
        newPostProgress = findViewById(R.id.new_post_progress);

        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();


        newPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        newPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * save the description for sending to HomeFragment
                 */
                postDesc = newPostDesc.getText().toString();


                String desc = newPostDesc.getText().toString();
                if (!TextUtils.isEmpty(desc) ){

                    //get the description 简化处理版本
                    newPostProgress.setVisibility(View.VISIBLE);


                    //get the image 简化处理版本
                    try {
                        File ImageFile = new File("C:\\Users\\DELL\\AndroidStudioProjects\\PostApp_lxy\\app\\src\\main\\res\\drawable\\img.png");
                        compressedImageFile = ImageFile;
                    }catch (Exception e){

                        e.printStackTrace();

                    }

                    // String randomName = random();
                    Map<String,Object> postMap = new HashMap<>();
                    postMap.put("image_url",newPostImage);
                    postMap.put("desc",desc);
                    postMap.put("user_id","520");
                    //postMap.put("timestamp",)
                    //由于不能翻墙，此处简化处理：
                    /**
                    String randomName = FieldValue.serverTimestamp().toString();

                    StorageReference filePath = storageReference.child("post_image").child(randomName+".jpg");
                    ......

                     */

                    //简化处理：
                    if (desc!= null){

                        Toast.makeText(NewPostActivity.this, "Post was added", Toast.LENGTH_LONG).show();
                        Intent mainIntent = new Intent(NewPostActivity.this,MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    
                    }else {

                        Toast.makeText(NewPostActivity.this, "you need to write a description about your post", Toast.LENGTH_LONG).show();
                        
                    }





                }else {

                    newPostProgress.setVisibility(View.INVISIBLE);

                }

            }
        });


        }


    public static String random(){

        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH);
        char tempChar;
        for (int i = 0; i<randomLength;i++){

            tempChar = (char) (generator.nextInt(96)+32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();

    }


    }
