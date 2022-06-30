package com.example.postapp_lxy;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * initial the like-commentsImage
     */
    private ImageView likeCommentsImage1 ;
    private ImageView likeCommentsImage2 ;
    private ImageView likeCommentsImage3 ;
    private ImageView likeCommentsImage4 ;

    /**
     * initial the account number of the comments likes
     */
    private TextView comentsLikeAccount1;
    private TextView comentsLikeAccount2;
    private TextView comentsLikeAccount3;
    private TextView comentsLikeAccount4;

    private int likeInital1 = 0;
    private int likeInital2 = 0;
    private int likeInital3 = 0;
    private int likeInital4 = 0;


    /**
     * initial the reply button:
     */
    private Button replyBtn1;
    private Button replyBtn2;
    private Button replyBtn3;
    private Button replyBtn4;

    /**
     * initial the comments:
     */
    private TextView comments_context1;
    public  String commentContext1;


    public NotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
         fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * set the reply button:
         */
        replyBtn1 =(Button) getActivity().findViewById(R.id.reply_btn1);
        replyBtn2 = (Button) getActivity().findViewById(R.id.reply_btn2);
        replyBtn3 = (Button) getActivity().findViewById(R.id.reply_btn3);
        replyBtn4 = (Button) getActivity().findViewById(R.id.reply_btn4);

        replyBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendToReply = new Intent(getActivity(),ReplyContent.class);
                startActivity(sendToReply);


            }
        });

        replyBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendToReply = new Intent(getActivity(),ReplyContent.class);
                startActivity(sendToReply);


            }
        });

        replyBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendToReply = new Intent(getActivity(),ReplyContent.class);
                startActivity(sendToReply);


            }
        });

        replyBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendToReply = new Intent(getActivity(),ReplyContent.class);
                startActivity(sendToReply);


            }
        });

        /**
         * set the comments likes account function :
         */
        // textView:Accounts
        comentsLikeAccount1 =(TextView) getActivity().findViewById(R.id.coments_likes_accout1);
        comentsLikeAccount2 =(TextView) getActivity().findViewById(R.id.coments_likes_accout2);
        comentsLikeAccount3 =(TextView) getActivity().findViewById(R.id.coments_likes_accout3);
        comentsLikeAccount4 =(TextView) getActivity().findViewById(R.id.coments_likes_accout4);


        // imageView: click to send likes
        likeCommentsImage1 = (ImageView) getActivity().findViewById(R.id.Like_Comments_imageView1); ;
        likeCommentsImage2 = (ImageView) getActivity().findViewById(R.id.Like_Comments_imageView2);
        likeCommentsImage3 = (ImageView) getActivity().findViewById(R.id.Like_Comments_imageView3);
        likeCommentsImage4 = (ImageView) getActivity().findViewById(R.id.Like_Comments_imageView4);

     likeCommentsImage1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            likeInital1++;
            String LikeAccount = String.valueOf(likeInital1);
            comentsLikeAccount1.setText(LikeAccount);

        }
     });

     likeCommentsImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                likeInital2++;
                String LikeAccount = String.valueOf(likeInital2);
                comentsLikeAccount2.setText(LikeAccount);

            }
        });

     likeCommentsImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                likeInital3++;
                String LikeAccount = String.valueOf(likeInital3);
                comentsLikeAccount3.setText(LikeAccount);

            }
        });
        likeCommentsImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                likeInital4++;
                String LikeAccount = String.valueOf(likeInital4);
                comentsLikeAccount4.setText(LikeAccount);

            }
        });

        /**
         * obtain the comments from  commentsActivity and show in the TextView:
         */
        comments_context1 = (TextView) getActivity().findViewById(R.id.comments_context1);
        comments_context1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                commentContext1 = CommentsActivity.commentText;
                comments_context1.setText(commentContext1);

            }
        });

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view =  inflater.inflate(R.layout.fragment_notification, container, false);
      return  view;
    }
}