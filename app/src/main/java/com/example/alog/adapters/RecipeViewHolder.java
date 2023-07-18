package com.example.alog.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alog.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title, publisher, socialScore;
    AppCompatImageView image;
    OnRecipeListener onRecipeListener;

    public RecipeViewHolder(@NonNull View itemView, OnRecipeListener mOnRecipeListener) {
        super(itemView);
        title= itemView.findViewById(R.id.textView2);
        publisher= itemView.findViewById(R.id.textView3);
        socialScore = itemView.findViewById(R.id.textView);
        image = itemView.findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        // this
        onRecipeListener.onRecipeClick(getAdapterPosition());
    }
}
