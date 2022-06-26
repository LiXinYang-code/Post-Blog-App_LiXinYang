package com.example.postapp_lxy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.postapp_lxy.redirectToMainActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FloatingActionButton addPostBtn;
    private String currentUser_id;

    private FirebaseFirestore firebaseFirestore;

    private BottomNavigationView mainbottomNav;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    /**
    //new changed +++
    private ImageView blogLikeBtn;
    private TextView blogLikeCt;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Photo Blog");
        }

        mainbottomNav = findViewById(R.id.mainBottomNav);

        //Fragments
        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();


/**
        //blog like check
        //add like
        blogLikeCt = findViewById(R.id.blog_like_count);
         blogLikeBtn = findViewById(R.id.blog_like_btn);
         blogLikeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        blogLikeCount.AddLikeCount();

        }

        });
         //count like
        if (blogLikeCount.getLikeCount()>0){

            blogLikeCt = findViewById(R.id.blog_like_count);
            blogLikeCt.setText(blogLikeCount.getLikeCount()+"Likes");

        }

*/

        //new changed--
      //  relpaceFragment(homeFragment);

        mainbottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId()){

                   case R.id.bottom_action_home:
                      relpaceFragment(homeFragment);
                      return true;

                   case R.id.bottom_action_account:
                       relpaceFragment(accountFragment);
                       return true;

                   case R.id.bottom_action_notification:
                       relpaceFragment(notificationFragment);
                       return true;

                   default:
                       return false;


               }
            }
        });

        addPostBtn = findViewById(R.id.add_post_btn);
        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendToNewPost();

            }
        });
        }


    @Override
    protected void onStart(){
        super.onStart();

        //因为手机暂时不能翻墙，导致firebase获取的currentUser为null，在这里做简单处理，初次跳转到注册页面
    /**
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser == null){

            sendToLogin();

        }
     */

        //因为手机暂时不能翻墙，导致firebase获取的currentUser为null，在这里做简单处理，初次跳转到注册页面

        if (redirectToMainActivity.getRedirToMain()==0){
            redirectToMainActivity.setRedirToMain(1);
            sendToLogin();
        }else {

            //因为不能翻墙，此处默认用户ID为520
            currentUser_id = "520";
            firebaseFirestore.collection("18206841644").document(currentUser_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if (task.isSuccessful()){

                        if (task.getResult().exists()){

                            Intent setupIntent = new Intent(MainActivity.this,SetupActivity.class);
                            startActivity(setupIntent);
                            finish();

                        }

                    }else {

                        String errorMessage = task.getException().getMessage();
                        Toast.makeText(MainActivity.this, "ERROR: "+errorMessage, Toast.LENGTH_LONG).show();

                    }


                }
            });
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_logout_btn:

                logOut();
                return true;

            case R.id.action_setting_btn:
                AccountSet();
                return true;

            default:
                return false;

        }


    }

    private void logOut() {

         mAuth.signOut();
         sendToLogin();

    }

    private void AccountSet(){
            sendToSetup();

    }

    private  void sendToSetup(){
        Intent setupIntent = new Intent(MainActivity.this,SetupActivity.class);
        startActivity(setupIntent);
        finish();

    }

    private void sendToLogin() {
        Intent loginIntent  = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }


    private void sendToNewPost(){

        Intent newPostBtn = new Intent(MainActivity.this,NewPostActivity.class);
        startActivity(newPostBtn);

    }

    private void relpaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();


    }



}