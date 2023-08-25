package com.avigail.coupons.dal;

import com.avigail.coupons.dto.UserData;
import com.avigail.coupons.entities.UserEntity;
import com.avigail.coupons.dto.User;
//import com.avigail.coupons.utils.JDBCUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsersDal extends CrudRepository<UserEntity, Long> {

    @Query("SELECT new com.avigail.coupons.dto.User (u.userName, u.id, u.password, u.type, u.company.id) FROM UserEntity u WHERE u.id= :id")
    User getUser(@Param("id")long id);

    @Query("SELECT new com.avigail.coupons.dto.User (u.userName, u.id, u.password, u.type, u.company.id) FROM UserEntity u")
    List<User> getAllUsers();

    @Query("SELECT new com.avigail.coupons.dto.User (u.userName, u.id, u.password, u.type, u.company.id) FROM UserEntity u WHERE u.company.id= :companyId")
    List<User> getUsersByCompanyId(@Param("companyId")Long id);

    @Query("SELECT new com.avigail.coupons.dto.UserData (u.userName, u.id, u.type, u.company.id) FROM UserEntity u WHERE u.userName= :userName AND u.password= :password")
    UserData login (@Param("userName")String userName, @Param("password")String password);








//    public long addUser(User user) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "INSERT INTO users (user_name, password, type, company_id)\n" +
//                    "VALUES (?, ?, ?, ?);";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, user.getUserName());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getType().getTypeName());
//            preparedStatement.setObject(4, user.getCompanyId());
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//            if (!resultSet.next()) {
//                throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create user, no id: " + user.toString());
//            }
//            return resultSet.getInt(1);
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create user: " + user.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public User getUser(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            // Establish a connection from the connection manager
//            connection = JDBCUtils.getConnection();
//            // Creating the SQL query
//            String sqlStatement = "SELECT id,user_name,password,type,company_id FROM users WHERE id=?";
//            // Combining between the syntax and our connection
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            // Replacing the question marks in the statement above with the relevant data
//            preparedStatement.setLong(1, id);
//            // Executing the query
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            if (resultSet.next()) {
//                return createUserFromResultSet(resultSet);
//            }
//            return null;
//
//        } catch (Exception e) {
//
//            // If there was an exception in the "try" block above, it is caught here and
//            // notifies a level above.
//            throw new ApplicationException(ErrorType.INVALID_USER, "Failed to get user", e);
//
//        } finally {
//            // Closing the resources
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//
//    private User createUserFromResultSet(ResultSet resultSet) throws ApplicationException {
//        try {
//            long id = resultSet.getLong("id");
//            String userName = resultSet.getString("user_name");
//            String password = resultSet.getString("password");
//            UserType type = UserType.valueOf(resultSet.getString("type"));
//            Integer companyId = (Integer) resultSet.getObject("company_id");
//
//            User user = new User(userName, id, password, type, companyId);
//            return user;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to get user", e);
//        }
//    }
//
//    public List<User> getAllUsers() throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<User> users = new ArrayList<User>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = "SELECT id,user_name,password,type,company_id FROM users";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                users.add(createUserFromResultSet(resultSet));
//            }
//            return users;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to get users", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static void updateUser(User user) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "UPDATE users SET user_name=?, password=?, type=?, company_id=? WHERE id=?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setString(1, user.getUserName());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getType().getTypeName());
//            preparedStatement.setObject(4, user.getCompanyId());
//            preparedStatement.setLong(5, user.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to update coupon:" + user.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static void deleteUser(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "DELETE FROM users WHERE id =?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "user not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public boolean isUserExist(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "SELECT id FROM users WHERE id =?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setLong(1, id);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            if (resultSet.next()) {
//                return true;
//            }
//            return false;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "userId not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<User> getUsersByCompanyId(long companyId) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<User> users = new ArrayList<User>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = "SELECT id,user_name,password,type,company_id FROM users where company_id = ?";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, companyId);
//
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                users.add(createUserFromResultSet(resultSet));
//            }
//            return users;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "no users under this company", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
}



