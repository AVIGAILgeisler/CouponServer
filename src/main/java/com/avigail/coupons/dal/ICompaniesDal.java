package com.avigail.coupons.dal;

import com.avigail.coupons.dto.Category;
import com.avigail.coupons.dto.Company;
import com.avigail.coupons.entities.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompaniesDal extends CrudRepository<CompanyEntity, Long> {

    @Query("SELECT new com.avigail.coupons.dto.Company (c.id, c.name, c.vatNumber, c.address, c.phoneNumber, c.email) FROM CompanyEntity c WHERE c.id= :id")
    Company getCompany(@Param("id")long id);
    @Query("SELECT new com.avigail.coupons.dto.Company (c.id, c.name, c.vatNumber, c.address, c.phoneNumber, c.email) FROM CompanyEntity c")
    List<Company> getAllCompanies();





//    public static long addCompany(Company company) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "INSERT INTO companies (name, vat_number, address, phone_number, email)\n" +
//                    "VALUES (?, ?, ?, ?, ?);";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
//
//            preparedStatement.setString(1, company.getName());
//            preparedStatement.setInt(2, company.getVatNumber());
//            preparedStatement.setString(3, company.getAddress());
//            preparedStatement.setString(4, company.getPhoneNumber());
//            preparedStatement.setString(5, company.getEmail());
//
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//            if (!resultSet.next()) {
//                throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to create company, no id: " + company.toString());
//            }
//            return resultSet.getLong(1);
//        } catch (Exception e) {
//
//            throw new ApplicationException(ErrorType.GENERAL_ERROR,"Failed to create company " + company.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//    public static void deleteCompany(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "DELETE FROM companies WHERE id =? ";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Company not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static void updateCompany(Company company) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "UPDATE companies SET name=?, address=?, phone_number=?, email=? WHERE id=?";
//
//            connection = JDBCUtils.getConnection();
//            preparedStatement = connection.prepareStatement(sqlStatement);
//
//            preparedStatement.setString(1, company.getName());
//            preparedStatement.setString(2, company.getAddress());
//            preparedStatement.setString(3, company.getPhoneNumber());
//            preparedStatement.setString(4, company.getEmail());
//            preparedStatement.setLong(5, company.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to update Company:" + company.toString(), e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public static Company getCompany(long id) throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            String sqlStatement = "SELECT id, name, vat_number, address, phone_number, email FROM companies WHERE id =?";
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
//                return createCompanyFromResultSet(resultSet);
//            }
//            return null;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Company not found", e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    public List<Company> getAllCompanies() throws ApplicationException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            List<Company> companies = new ArrayList<Company>();
//            connection = JDBCUtils.getConnection();
//
//            String sqlStatement = "SELECT id, name, vat_number, address, phone_number, email FROM companies";
//            preparedStatement = connection.prepareStatement(sqlStatement);
//            preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getResultSet();
//
//            while (resultSet.next()) {
//                companies.add(createCompanyFromResultSet(resultSet));
//            }
//            return companies;
//
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Failed to get Companies", e);
//
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
//
//    private static Company createCompanyFromResultSet(ResultSet resultSet) throws ApplicationException {
//        try {
//            long id = resultSet.getLong("id");
//            String name = resultSet.getString("name");
//            int vatNumber = resultSet.getInt("vat_number");
//            String address = resultSet.getString("address");
//            String phoneNumber = resultSet.getString("phone_number");
//            String email = resultSet.getString("email");
//            Company company = new Company(id, name, vatNumber, address, phoneNumber, email);
//            return company;
//        } catch (Exception e) {
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "failed to create company", e);
//        }
//    }
//    public boolean isCompanyExist(long id) throws ApplicationException {
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
//            throw new ApplicationException(ErrorType.GENERAL_ERROR, "Not found companyId " +id , e);
//        } finally {
//            JDBCUtils.closeResources(connection, preparedStatement);
//        }
//    }
}
