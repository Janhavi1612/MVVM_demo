package com.janhavi.android.mvvm_demo.ViewModel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.janhavi.android.mvvm_demo.FirebaseQueryLiveData;
import com.janhavi.android.mvvm_demo.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostViewModel extends ViewModel {

    private List<Post> allPosts = new ArrayList<>();
    private static final DatabaseReference POST_REF =
            FirebaseDatabase.getInstance().getReference("/friends");
    private final FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(POST_REF);

   /* public LiveData<DataSnapshot> getLiveData(){
        return liveData;
    }*/

    public LiveData<List<Post>> getPostsLiveData(){
        LiveData<List<Post>> postsLiveData = Transformations.map(liveData, new Deserializer());
        return postsLiveData;
    }

    private class Deserializer implements Function<DataSnapshot,List<Post>>{

        @Override
        public List<Post> apply(DataSnapshot dataSnapshot) {
            allPosts.clear();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                Post post = ds.getValue(Post.class);
                allPosts.add(post);
            }
            return allPosts;
        }
    }
}
