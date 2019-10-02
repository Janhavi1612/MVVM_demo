package com.janhavi.android.mvvm_demo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.janhavi.android.mvvm_demo.R;
import com.janhavi.android.mvvm_demo.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<Post> posts = new ArrayList<Post>();
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post currentPost = posts.get(position);
        holder.tv_name.setText(currentPost.getName());
        holder.tv_id.setText(currentPost.getId());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> allPosts){
        this.posts = allPosts;
        notifyDataSetChanged();
    }

    class PostHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_id;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.Name);
            tv_id = itemView.findViewById(R.id.Id);

        }
    }
}
