package com.janhavi.android.mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.janhavi.android.mvvm_demo.Adapter.PostAdapter;
import com.janhavi.android.mvvm_demo.ViewModel.PostViewModel;
import com.janhavi.android.mvvm_demo.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PostAdapter postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);

        //final List<Post> allPosts = new ArrayList<Post>();

        PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        LiveData<List<Post>> myLiveData = postViewModel.getPostsLiveData();

        myLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                if(!posts.isEmpty()){
                    postAdapter.setPosts(posts);
                }
            }
        });
     /*   myLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(DataSnapshot dataSnapshot) {
                if (dataSnapshot!= null){
                  //  Log.e("dummy0",dataSnapshot.child("0").getValue().toString());
                   // Log.e("dummy1",dataSnapshot.child("1").getValue().toString());
                    //postAdapter.setPosts(allPosts);
                   // HashMap<String, Post> postHashMap = (HashMap<String, Post>)dataSnapshot.getValue();

                    //allPosts.clear();
                    //allPosts = postHashMap.l
                }
            }
        });*/



    }
}
