package com.example.postapp_lxy;

public class redirectToMainActivity {

    private static int redirToMain = 0;
    public static void setRedirToMain(int temp){
        redirToMain = temp;
    }

    public static int getRedirToMain() {
        return redirToMain;
    }
}
