package com.ottapp.android.basemodule.dao.task.category;

import android.os.AsyncTask;

import com.ottapp.android.basemodule.dao.CategoryDataDao;
import com.ottapp.android.basemodule.models.CategoryListDataModel;

public class DeleteCategoryTask extends AsyncTask<CategoryListDataModel, Void, Boolean> {

    private CategoryDataDao categoryDao;

    public DeleteCategoryTask(CategoryDataDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    protected Boolean doInBackground(CategoryListDataModel... models) {
        try {
            categoryDao.delete(models[0]);
            return true;
        } catch (Exception ignored) {
            ignored.printStackTrace();
            return false;
        }
    }
}
