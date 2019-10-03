package com.janhavi.android.mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.janhavi.android.mvvm_demo.Adapter.PostAdapter;
import com.janhavi.android.mvvm_demo.ViewModel.PostViewModel;
import com.janhavi.android.mvvm_demo.model.Upload;

import java.util.List;

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

        //final List<Upload> allPosts = new ArrayList<Upload>();

        PostViewModel postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        LiveData<List<Upload>> myLiveData = postViewModel.getPostsLiveData();

        myLiveData.observe(this, new Observer<List<Upload>>() {
            @Override
            public void onChanged(List<Upload> posts) {
                if(!posts.isEmpty()){
                    Log.e("test3",""+posts.get(0).toString());
                    postAdapter.setPosts(posts);
                }
            }
        });
     /*   myLiveData.observe(this, new Observer<List<Upload>>() {
            @Override
            public void onChanged(DataSnapshot dataSnapshot) {
                if (dataSnapshot!= null){
                  //  Log.e("dummy0",dataSnapshot.child("0").getValue().toString());
                   // Log.e("dummy1",dataSnapshot.child("1").getValue().toString());
                    //postAdapter.setPosts(allPosts);
                   // HashMap<String, Upload> postHashMap = (HashMap<String, Upload>)dataSnapshot.getValue();

                    //allPosts.clear();
                    //allPosts = postHashMap.l
                }
            }
        });*/



    }
}
