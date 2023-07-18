package com.example.alog.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.alog.models.Recipe;
import com.example.alog.repositories.RecipeRepo;

import java.util.List;

public class RecipeListViewModel extends ViewModel {
    // add this
    private RecipeRepo mRecipeRepository;


    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepo.getInstance();
    }



    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeRepository.getRecipes();
    }

 //ADD THIS
    public void searchRecipesApi(String query,int pageNumber){
        mRecipeRepository.searchRecipesApi(query, pageNumber);
    }

}



















