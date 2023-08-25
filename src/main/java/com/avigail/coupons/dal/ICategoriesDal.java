package com.avigail.coupons.dal;

import com.avigail.coupons.dto.Category;
import com.avigail.coupons.dto.ExtendedCoupon;
import com.avigail.coupons.entities.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoriesDal extends CrudRepository<CategoryEntity, Long> {

    @Query("SELECT new com.avigail.coupons.dto.Category (c.id, c.name) FROM CategoryEntity c WHERE c.id= :id")
    Category getCategory(@Param("id")long id);

    @Query("SELECT new com.avigail.coupons.dto.Category (c.id, c.name) FROM CategoryEntity c")
    List<Category> getAllCategories();


























//    public static long addCategory(Category category) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            String sqlStatement = "INSERT INTO categories (name)\n" + "VALUES (?);";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, category.getName());
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//            if (!resultSet.next()) {
//                throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create category, no id: " + category.toString());
//            }
//            return resultSet.getLong(1);
//        } catch (Exception e) {
//
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create category " + category.toString(), e);
//        }
//    }
//
//    public static void deleteCategory(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "DELETE FROM categories WHERE id =? ";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Category not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static void updateCategory(Category category) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "UPDATE categories SET name=? WHERE id=?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setString(1, category.getName());
//            preparedStatement.setLong(2, category.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to update category:" + category.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static Category getCategory(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "SELECT id, name FROM categories WHERE id =?";
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//            if (resultSet.next()) {
//                return createCategoryFromResultSet(resultSet);
//            }
//            return null;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Category not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Category> getAllCategories() throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Category> categories = new ArrayList<Category>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = "SELECT id, name FROM categories";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                categories.add(createCategoryFromResultSet(resultSet));
//            }
//            return categories;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to get category", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    private static Category createCategoryFromResultSet(ResultSet resultSet) throws ApplicationException {
//        try {
//            long id = resultSet.getLong("id");
//            String name = resultSet.getString("name");
//            Category category = new Category(id, name);
//            return category;
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "failed to create category", e);
//        }
//    }
//    public boolean isCategoryExist(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "SELECT id FROM categories WHERE id =?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, id);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            if (resultSet.next()) {
//                return true;
//            }
//            return false;
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Category id not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
}
