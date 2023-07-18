package com.example.alog.repositories;

import androidx.lifecycle.LiveData;

import com.example.alog.models.Recipe;
import com.example.alog.requests.responses.RecipeApiClient;

import java.util.List;

public class RecipeRepo {
    private static RecipeRepo instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRepo getInstance(){
        if(instance == null){
            instance = new RecipeRepo();
        }
        return instance;
    }

    private RecipeRepo() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipesApi(String query,int pageNumber){

        mRecipeApiClient.searchRecipesApi(query,pageNumber);
    }
}
