package com.avigail.coupons.logic;

import com.avigail.coupons.exception.ApplicationException;
import com.avigail.coupons.dal.ICompaniesDal;
import com.avigail.coupons.dto.Company;
import com.avigail.coupons.entities.CompanyEntity;
import com.avigail.coupons.enums.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyLogic extends GeneralLogic {
    private ICompaniesDal companiesDal;
    @Autowired
    public CompanyLogic(ICompaniesDal companiesDal) {
        this.companiesDal = companiesDal;
    }

    public CompanyLogic() {
    }

    public void addCompany(Company company) throws ApplicationException {
        validateCompanyData(company);
        CompanyEntity companyEntity=new CompanyEntity(company);
        this.companiesDal.save(companyEntity);
    }
    public void updateCompany(Company company) throws ApplicationException {
        validateCompanyData(company);
        CompanyEntity companyEntity=new CompanyEntity(company);
        this.companiesDal.save(companyEntity);
    }
    public void deleteCompany(long id) throws ApplicationException {
        this.companiesDal.deleteById(id);
    }
    public Company getCompany(long id) throws ApplicationException {
        return this.companiesDal.getCompany(id);
    }
    public List<Company> getAllCompanies() throws ApplicationException {
        return this.companiesDal.getAllCompanies();
    }

    private void validateCompanyData(Company company) throws ApplicationException {
        validateCompanyAddress(company.getAddress());
        validateCompanyEmail(company.getEmail());
        validateCompanyVatNumber(company.getVatNumber());
        validateCompanyPhone(company.getPhoneNumber());
    }

    private void validateCompanyPhone(String phoneNumber) throws ApplicationException {
        for (int i = 1; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER);
            }
        }
    }
    private void validateCompanyEmail(String email) throws ApplicationException {
        validateEmailAddressStructure(email);
    }

    private void validateCompanyVatNumber(int vatNumber) throws ApplicationException {
        if (vatNumber < 500000000 || vatNumber > 519999999) {
            throw new ApplicationException(ErrorType.INVALID_VAT_NUMBER);
        }
    }

    private void validateCompanyAddress(String address) throws ApplicationException {
        if (address.length() > 25 || address.length() < 5) {
            throw new ApplicationException(ErrorType.INVALID_ADDRESS);
        }
    }

    boolean isCompanyIdExist(Long companyId) throws ApplicationException {
        return companiesDal.existsById(companyId);
    }
}
