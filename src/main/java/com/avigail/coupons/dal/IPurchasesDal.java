package com.avigail.coupons.dal;

import com.avigail.coupons.dto.ExtendedCoupon;
import com.avigail.coupons.dto.ExtendedPurchase;
import com.avigail.coupons.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IPurchasesDal extends CrudRepository<PurchaseEntity, Long> {

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name,p.coupon.description,p.coupon.price,p.coupon.startDate, p.coupon.endDate,p.coupon.company.id,p.coupon.company.name, p.user.userName, p.coupon.category.id, p.coupon.category.name) FROM PurchaseEntity p ")
    List<ExtendedPurchase> getAllPurchase();

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name,p.coupon.description,p.coupon.price,p.coupon.startDate, p.coupon.endDate,p.coupon.company.id,p.coupon.company.name, p.user.userName, p.coupon.category.id, p.coupon.category.name) FROM PurchaseEntity p WHERE p.id= :id")
    ExtendedPurchase getPurchase(@Param("id")long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name,p.coupon.description,p.coupon.price,p.coupon.startDate, p.coupon.endDate,p.coupon.company.id,p.coupon.company.name, p.user.userName, p.coupon.category.id, p.coupon.category.name) FROM PurchaseEntity p WHERE p.coupon.company.id= :companyId")
    List<ExtendedPurchase> getPurchasesByCompanyId(@Param("companyId")Long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name,p.coupon.description,p.coupon.price,p.coupon.startDate, p.coupon.endDate,p.coupon.company.id,p.coupon.company.name, p.user.userName, p.coupon.category.id, p.coupon.category.name) FROM PurchaseEntity p WHERE p.user.id= :userId")
    List<ExtendedPurchase> getPurchasesByUserId(@Param("userId")long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name,p.coupon.description,p.coupon.price,p.coupon.startDate, p.coupon.endDate,p.coupon.company.id,p.coupon.company.name, p.user.userName, p.coupon.category.id, p.coupon.category.name) FROM PurchaseEntity p WHERE p.coupon.category.id= :categoryId")
    List<ExtendedPurchase> getPurchasesByCategoryId(@Param("categoryId") long id);

    @Query("SELECT new com.avigail.coupons.dto.ExtendedPurchase (p.id, p.coupon.id, p.user.id, p.amount, p.date, p.coupon.name, p.coupon.description, p.coupon.price, p.coupon.startDate, p.coupon.endDate,p.coupon.company.id, p.coupon.company.name, p.user.userName, p.coupon.category.id,p.coupon.category.name) FROM PurchaseEntity p WHERE p.date< :startDate AND p.date> :endDate")
    List<ExtendedPurchase> getPurchasesByDateRange(@Param("startDate")Date startDate, @Param("endDate") Date endDate);





//    public static long addPurchase(Purchase purchase) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "INSERT INTO purchases (coupon_id, user_id, amount, date)\n" +
//                    "VALUES (?, ?, ?, ? );";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setLong(1, purchase.getCouponId());
//            preparedStatement.setLong(2, purchase.getUserId());
//            preparedStatement.setFloat(3, purchase.getAmount());
//            preparedStatement.setDate(4, (Date) purchase.getDate());
//
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//            if (!resultSet.next()) {
//                throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create purchases, no id: " + purchase.toString());
//            }
//
//            return resultSet.getLong(1);
//        } catch (Exception e) {
//
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, purchase.toString(), e);
//        }
//    }
//
//    public static void deletePurchase(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "DELETE FROM purchases WHERE id =?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "purchase not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static void updatePurchase(Purchase purchase) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "UPDATE purchases SET coupon_id=?, user_id=?, amount=?, date=? WHERE id=?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, purchase.getCouponId());
//            preparedStatement.setLong(2, purchase.getUserId());
//            preparedStatement.setFloat(3, purchase.getAmount());
//            preparedStatement.setDate(4, (Date) purchase.getDate());
//            preparedStatement.setLong(5, purchase.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to update purchase:" + purchase.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static Purchase getPurchase(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n" +
//                    "where p.id=?";
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, id);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            if (resultSet.next()) {
//                return createExtendedPurchaseFromResultSet(resultSet);
//            }
//            return null;
//
//        } catch (Exception innerException) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Couldn't access the requested purchase:"+ id, innerException);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    private static ExtendedPurchase createExtendedPurchaseFromResultSet(ResultSet resultSet) throws ApplicationException {
//        try {
//            long purchaseId = resultSet.getLong("id");
//            long userId = resultSet.getLong("user_id");
//            long couponId = resultSet.getLong("coupon_id");
//            int amountOfProducts = resultSet.getInt("amount");
//            Date purchaseDate = resultSet.getDate("purchase_date");
//            String couponName = resultSet.getString("coupon_name");
//            String couponDescription = resultSet.getString("coupon_description");
//            float couponPrice = resultSet.getFloat("coupon_price");
//            Date startDate = resultSet.getDate("coupon_start_date");
//            Date endDate = resultSet.getDate("coupon_end_date");
//            long companyId = resultSet.getLong("company_id");
//            String companyName = resultSet.getString("company_name");
//            String userName = resultSet.getString("user_name");
//            long categoryId = resultSet.getLong("category_id");
//            String categoryName = resultSet.getString("category_name");
//
//            ExtendedPurchase extendedPurchase = new ExtendedPurchase(purchaseId, userId, couponId, amountOfProducts, purchaseDate, couponName, couponDescription, couponPrice, startDate, endDate, companyId, companyName, userName, categoryId, categoryName);
//            return extendedPurchase;
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Could not load purchase from result set " + resultSet, e);
//        }
//    }
//
//    private static Purchase createPurchaseFromResultSet(ResultSet resultSet) throws ApplicationException {
//        try {
//
//            long id = resultSet.getLong("id");
//            long couponId = resultSet.getLong("coupon_id");
//            long userId = resultSet.getLong("user_id");
//            int amount = resultSet.getInt("amount");
//            java.util.Date date = resultSet.getDate("date");
//
//
//            Purchase purchase = new Purchase(id, couponId, userId, amount, date);
//            return purchase;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create purchase", e);
//        }
//    }
//
//    public List<Purchase> getAllPurchase() throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Purchase> purchases = new ArrayList<Purchase>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//            while (resultSet.next()) {
//                purchases.add(createExtendedPurchaseFromResultSet(resultSet));
//            }
//            return purchases;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Couldn't getAllPurchases", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Purchase> getPurchasesByCompanyId(long companyId) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Purchase> purchases = new ArrayList<Purchase>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n" +
//                    "where c.company_id=?;";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, companyId);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                purchases.add(createExtendedPurchaseFromResultSet(resultSet));
//            }
//            return purchases;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to get purchase", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Purchase> getPurchasesByUserId(long userId) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Purchase> purchases = new ArrayList<Purchase>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n" +
//                    "where user_id=?;";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, userId);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                purchases.add(createExtendedPurchaseFromResultSet(resultSet));
//            }
//            return purchases;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Couldn't get Purchases By userId "+userId, e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Purchase> getPurchasesByCategoryId(long categoryId) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Purchase> purchases = new ArrayList<Purchase>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n" +
//                    "where category_id=?;";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, categoryId);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                purchases.add(createExtendedPurchaseFromResultSet(resultSet));
//            }
//            return purchases;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Couldn't get Purchases By categoryId "+ categoryId, e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Purchase> getPurchasesByDateRange(Date startDate, Date endDate) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Purchase> purchases = new ArrayList<Purchase>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = " SELECT p.id, p.coupon_id, p.user_id, p.amount," +
//                    "p.date as purchase_date," +
//                    "c.name as coupon_name,\n" +
//                    "c.description as coupon_description,  c.price as coupon_price, c.start_date as coupon_start_date,\n" +
//                    "c.end_date as coupon_end_date , co.id as company_id, co.name as company_name,\n" +
//                    "u.user_name, c.category_id,c.name as category_name\n" +
//                    "FROM purchases p \n" +
//                    "join coupons  c on p.coupon_id = c.id \n" +
//                    "join users u on p.user_id=u.id\n" +
//                    "join companies co on c.company_id=co.id\n" +
//                    "where end_date BETWEEN ? AND ?;";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setDate(1, startDate);
//            preparedStatement.setDate(2, endDate);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                purchases.add(createExtendedPurchaseFromResultSet(resultSet));
//            }
//            return purchases;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Couldn't get Purchases ByDateRange" +startDate + " "+endDate, e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
}
