package com.example.alog;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alog.adapters.OnRecipeListener;
import com.example.alog.adapters.RecipeAdapter;
import com.example.alog.viewmodels.RecipeListViewModel;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alog.models.Recipe;
import java.util.List;



public class RecipeListActivity extends BaseActivity implements OnRecipeListener {

    private static final String TAG = "RecipeListActivity";
    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recipe_list);
            mRecyclerView = findViewById(R.id.recipe_list);

            mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);
            initRecyclerView();
            subscribeObservers();

            findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    testRetrofitRequest();
                }
            });
        }


    private void subscribeObservers() {

        mRecipeListViewModel.getRecipes().observe(this, (recipes) -> {

                if (recipes != null) {
                    for(Recipe recipe: recipes){
                        Log.d("COUCOU", "printRecipes: " + recipe.getRecipe_id() + ", " + recipe.getTitle());
                    }
                }
             // Update recipes
                 mAdapter.setRecipes(recipes);
        });
    }
    private void initRecyclerView(){
        mAdapter = new RecipeAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void testRetrofitRequest() {
        mRecipeListViewModel.searchRecipesApi("cabbage",1);
    }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }
}