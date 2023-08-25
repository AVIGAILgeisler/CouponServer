package com.avigail.coupons.logic;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dal.ICategoriesDal;
import com.avigail.coupons.dto.Category;
import com.avigail.coupons.entities.CategoryEntity;
import com.avigail.coupons.enums.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLogic {
    private ICategoriesDal categoriesDal;

    @Autowired
    public CategoryLogic(ICategoriesDal categoriesDal) {
        this.categoriesDal = categoriesDal;
    }

    public CategoryLogic() {
    }

    public void addCategory(Category category) throws ApplicationException {
        validateCategory(category);
        CategoryEntity categoryEntity=new CategoryEntity(category);
        this.categoriesDal.save(categoryEntity);
    }

    public void updateCategory(Category category) throws ApplicationException {
        validateCategory(category);
        CategoryEntity categoryEntity=new CategoryEntity(category);
        this.categoriesDal.save(categoryEntity);
    }
    public void deleteCategory(long id) throws ApplicationException {
        this.categoriesDal.deleteById(id);
    }
    public Category getCategory(long id) throws ApplicationException {
        return categoriesDal.getCategory(id);
    }

    public List<Category> getAllCategories() throws ApplicationException {
        return categoriesDal.getAllCategories();
    }

    private void validateCategory(Category category) throws ApplicationException {
        validateCategoryName(category);
    }

    private void validateCategoryName(Category category) throws ApplicationException {
        if (category.getName().length() > 45) {
            throw new ApplicationException(ErrorType.NAME_TOO_LONG);
        }
        if (category.getName().length() < 2) {
            throw new ApplicationException(ErrorType.NAME_TOO_SHORT);
        }
    }

    boolean isCategoryExist(long categoryId) throws ApplicationException {
        return categoriesDal.existsById(categoryId);
    }
}

