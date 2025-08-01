package com.example.moneytracker.interfaces;import androidx.lifecycle.LiveData;import com.example.moneytracker.data.db.Category;import java.util.List;public interface ICategoryRepository {    LiveData<List<Category>> getAllCategories();    LiveData<Category> getCategoryById(int categoryId);    void insert(Category category);    void update(Category category);    void delete(Category category);}