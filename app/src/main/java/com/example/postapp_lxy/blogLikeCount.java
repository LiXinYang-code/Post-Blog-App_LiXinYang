package com.example.postapp_lxy;

public class blogLikeCount {

    private static int likeCount=0;

    public static void AddLikeCount() {
        blogLikeCount.likeCount = likeCount+1;
    }

    public static int getLikeCount() {
        return likeCount;
    }
}
