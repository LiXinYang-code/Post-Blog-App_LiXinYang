package com.example.postapp_lxy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private CircleImageView setupImage;
    private EditText setupName;
    private Button setupBtn;
    private ProgressBar setupProgress;

    private StorageReference storageReference;
    private FirebaseAuth  firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    public static String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Account Setup");
        }


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore  = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        setupImage = findViewById(R.id.setup_image);
        setupName = findViewById(R.id.setup_name);
        setupBtn = findViewById(R.id.setup_btn);
        setupProgress = findViewById(R.id.setup_progress);

        setupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * save userName for sending to accoutFra:
                 */
                userName = setupName.getText().toString();


                String user_name = setupName.getText().toString();

                // Here is different with the Youtobe video, this app did not use the github lib to set the account image
                if (!TextUtils.isEmpty(user_name)){

                    setupProgress.setVisibility(View.VISIBLE);
                    /**
                    String user_id = firebaseAuth.getCurrentUser().getUid();

                    StorageReference image_path = storageReference.child("profile_image").child(user_id+".jpg");
                     */

                    //因为不能翻墙，此处采用简化处理：输入不为空就默认成功设置账户
                    if (!user_name.isEmpty()){

                        Toast.makeText(SetupActivity.this,"successful setting",Toast.LENGTH_LONG).show();

                        Intent mainIntent = new Intent(SetupActivity.this,MainActivity.class);
                        startActivity(mainIntent);
                        finish();

                        /**
                        Map<String,String> userMap = new HashMap<>();
                        userMap.put("name",user_name);

                        userMap.put("image",download_uri.toString());
                       firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               
                               if (task.isSuccessful()){

                                   Toast.makeText(SetupActivity.this, "The User Settings are updated. ", Toast.LENGTH_SHORT).show();
                                   Intent mainIntent = new Intent(SetupActivity.this,MainActivity.class);
                                   startActivity(mainIntent);
                                    finish();

                               }else {
                                   
                                   String error = task.getException().getMessage();
                                   Toast.makeText(SetupActivity.this, "FireStore Error :", Toast.LENGTH_SHORT).show();
                                   
                               }
                               
                           }
                       });
                       */

                    }


                }
                else {

                    Toast.makeText(SetupActivity.this,"Error : please try to set your name again ",Toast.LENGTH_LONG).show();

                    setupProgress.setVisibility(View.INVISIBLE);

                }

            }
        });

        setupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

                    if(ContextCompat.checkSelfPermission(SetupActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(SetupActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(SetupActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);


                    }else {

                        Toast.makeText(SetupActivity.this, "You already have permission", Toast.LENGTH_LONG).show();

                    }

                }else {

                    Toast.makeText(SetupActivity.this, "You already have permission", Toast.LENGTH_LONG).show();

                }

                //new change ++
                setupImage.setImageURI(Uri.parse("C:\\Users\\DELL\\AndroidStudioProjects\\PostApp_lxy\\app\\src\\main\\res\\drawable\\img.png"));
                Toast.makeText(SetupActivity.this, "An user image has been settled automatically", Toast.LENGTH_LONG).show();

            }

        });

    }

    

}