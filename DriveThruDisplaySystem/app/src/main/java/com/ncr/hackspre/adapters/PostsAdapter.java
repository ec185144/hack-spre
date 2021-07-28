package com.ncr.hackspre.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncr.hackspre.R;
import com.ncr.hackspre.model.RetroPosts;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<RetroPosts> postData;
    private Context context;

    public PostsAdapter(Context context, List<RetroPosts> postData) {
        this.postData = postData;
        this.context = context;
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {

        public final View view;

        TextView postTitle;
        TextView itemCost;
        TextView itemNumber;

        PostsViewHolder(View postView) {
            super(postView);

            view = postView;

            postTitle = view.findViewById(R.id.item);
            itemCost = view.findViewById(R.id.itemCost);
            itemNumber = view.findViewById(R.id.itemNumber);
        }

    }

    @NonNull
    @NotNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull @NotNull final ViewGroup parent,
                                              final int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_row, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull final PostsAdapter.PostsViewHolder holder,
                                 final int position) {
        holder.postTitle.setText(postData.get(position).getBody());
        holder.itemCost.setText(String.valueOf(postData.get(position).getUserID()));
        holder.itemNumber.setText(String.valueOf(position+1));

        // Picasso for images
        //        Picasso.Builder builder = new Picasso.Builder(context);
        //        builder.downloader(new OkHttpDownloader(context));


    }

    @Override
    public int getItemCount() {
        return postData.size();
    }
}
