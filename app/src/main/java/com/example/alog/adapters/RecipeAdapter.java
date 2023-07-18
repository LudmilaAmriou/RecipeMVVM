package com.example.alog.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.alog.R;
import com.example.alog.models.Recipe;

import java.util.ArrayList;

import java.util.List;
public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Recipe> mRecipes;
    private OnRecipeListener mOnRecipeListener;

    public RecipeAdapter(OnRecipeListener onRecipeListener) {
        mOnRecipeListener = onRecipeListener;
        mRecipes = new ArrayList<>();
    }


    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipes_layout, viewGroup, false);
        return new RecipeViewHolder(itemView,mOnRecipeListener);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_launcher_background);

        Glide.with(((RecipeViewHolder) viewHolder).itemView)
                .setDefaultRequestOptions(options)
                .load(mRecipes.get(position).getImage_url())
                .into(((RecipeViewHolder) viewHolder).image);

        ((RecipeViewHolder) viewHolder).title.setText(mRecipes.get(position).getTitle());
        ((RecipeViewHolder) viewHolder).publisher.setText("Publisher: " + mRecipes.get(position).getPublisher());
        ((RecipeViewHolder) viewHolder).socialScore.setText("Social score: "+ String.valueOf(Math.round(mRecipes.get(position).getSocial_rank())));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public void setRecipes(List<Recipe> recipes){
        mRecipes = recipes;
        notifyDataSetChanged();
    }


}