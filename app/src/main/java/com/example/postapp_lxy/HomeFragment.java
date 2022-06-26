package com.example.postapp_lxy;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView  blog_list_view;
    private List<BlogPost> blog_list;
    private  BlogRecyclerAdapter blogRecyclerAdapter;
    private ImageView blogLikeBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public HomeFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      //  View view = inflater.inflate(R.layout.fragment_home,container,false);

        //new changed ++
        View view = inflater.inflate(R.layout.blog_list_item,container,false);


        blog_list = new ArrayList<>();
        blog_list_view = getActivity().findViewById(R.id.blog_list_view);

/**

         BlogPost blogPost = new BlogPost("520","unkown","happy times fly away","C:\\Users\\DELL\\AndroidStudioProjects\\PostApp_lxy\\app\\src\\main\\res\\drawable\\img.png",
                "2022/6/20  17:42","lixinyang");
         blog_list.add(blogPost);
         blogRecyclerAdapter.notifyDataSetChanged();


        blogRecyclerAdapter = new BlogRecyclerAdapter(blog_list);

        blog_list_view.setLayoutManager(new LinearLayoutManager(container.getContext()));
        blog_list_view.setAdapter(blogRecyclerAdapter);
 */


        /**
        //此处做简化处理
        BlogPost blogPost = new BlogPost("520","unkown","happy times fly away","C:\\Users\\DELL\\AndroidStudioProjects\\PostApp_lxy\\app\\src\\main\\res\\drawable\\img.png",
                "2022/6/20  17:42");
        blog_list.add(blogPost);


        blogRecyclerAdapter.notifyDataSetChanged();
         */


        // Inflate the layout for this fragment
        return  view;
    }
}