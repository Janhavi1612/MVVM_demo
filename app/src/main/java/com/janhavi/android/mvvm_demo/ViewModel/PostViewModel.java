package com.janhavi.android.mvvm_demo.ViewModel;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.janhavi.android.mvvm_demo.FirebaseQueryLiveData;
import com.janhavi.android.mvvm_demo.model.Upload;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel extends ViewModel {

    private List<Upload> allPosts = new ArrayList<>();
    private static final DatabaseReference POST_REF =
            FirebaseDatabase.getInstance().getReference("posts");
    private final FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(POST_REF);

   /* public LiveData<DataSnapshot> getLiveData(){
        return liveData;
    }*/

    public LiveData<List<Upload>> getPostsLiveData(){
        LiveData<List<Upload>> postsLiveData = Transformations.map(liveData, new Deserializer());
        return postsLiveData;
    }

    private class Deserializer implements Function<DataSnapshot,List<Upload>>{

        @Override
        public List<Upload> apply(DataSnapshot dataSnapshot) {
            allPosts.clear();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                Upload post = ds.getValue(Upload.class);
                Log.e("test2",""+post.getUserName());
                allPosts.add(post);
            }
            return allPosts;
        }
    }
}
