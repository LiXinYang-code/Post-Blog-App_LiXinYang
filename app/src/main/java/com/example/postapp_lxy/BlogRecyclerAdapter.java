package com.example.postapp_lxy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {

    public List<BlogPost> blog_list;
   // public Context context;

    public BlogRecyclerAdapter(List<BlogPost> blog_list){

        this.blog_list = blog_list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_list_item,parent,false);
       // context = parent.getContext();

        return new ViewHolder(view);



    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String desc_data = blog_list.get(position).getDesc();
        holder.setDescText(desc_data);

        String image_url = blog_list.get(position).getImage_url();
        //holder.setBlogImage(image_url);


        //new changed
        /**
        TextView textView = holder.descView;
        textView.setText(blog_list.get(position).getDesc());
         */
        TextView naView = holder.nameView;
        naView.setText(blog_list.get(position).getUser_name());
        TextView daText = holder.dateView;
        daText.setText(blog_list.get(position).getTimestamp());

        CircleImageView circleImageView = holder.circleImageView;
        ImageView imageView = holder.blogImageView;


        //Likes Features:
        holder.blogLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                blogLikeCount.AddLikeCount();

            }

        });

        //Get likes Count:
        if (blogLikeCount.getLikeCount()>0){

            holder.updateLikesCount(blogLikeCount.getLikeCount());

        }




    }

    @Override
    public int getItemCount() {

        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView descView;
        private View mView;

        //new:
        private TextView nameView;
        private TextView dateView;
        private ImageView blogImageView;
        private CircleImageView circleImageView;

        private ImageView blogLikeBtn;
        private TextView blogLikeCount;


        public ViewHolder(View itemView){
            super(itemView);
            mView = itemView;

            blogLikeBtn = mView.findViewById(R.id.blog_like_btn);


            //new:
            descView = (TextView) itemView.findViewById(R.id.blog_desc);
            nameView = (TextView) itemView.findViewById(R.id.blog_user_name);
            dateView = (TextView) itemView.findViewById(R.id.blog_date);
            blogImageView = (ImageView) itemView.findViewById(R.id.blog_image);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.blog_user_image);
        }

        public void setDescText(String descText){

            descView = mView.findViewById(R.id.blog_desc);
            descView.setText(descText);

        }

        /**
        public void setBlogImage(String downloadUri){

            blogImageView = mView.findViewById(R.id.blog_image);
            Glide.with(context).load(downloadUri).into(blogImageView);

        }
         */

        public void updateLikesCount(int count){

            blogLikeCount = mView.findViewById(R.id.blog_like_count);
            blogLikeCount.setText(count+"Likes");

        }

    }


}
