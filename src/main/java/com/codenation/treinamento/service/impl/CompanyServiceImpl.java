package com.codenation.treinamento.service.impl;

import com.codenation.treinamento.domain.dao.AddressDAO;
import com.codenation.treinamento.domain.dao.CompanyDAO;
import com.codenation.treinamento.domain.dao.UserDAO;
import com.codenation.treinamento.entity.Address;
import com.codenation.treinamento.entity.Company;
import com.codenation.treinamento.entity.User;
import com.codenation.treinamento.service.CompanyService;
import com.codenation.treinamento.vo.AddressVO;
import com.codenation.treinamento.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDAO companyDAO;
    @Autowired
    AddressDAO addressDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public CompanyVO createCompany(CompanyVO companyVO) {
        Address address = new Address();
        if(companyVO.getAddress().getId() == null){
            address.setCity(companyVO.getAddress().getCity());
            address.setCountry(companyVO.getAddress().getCountry());
            address.setDistrict(companyVO.getAddress().getDistrict());
            address.setNumber(companyVO.getAddress().getNumber());
            address.setStreet(companyVO.getAddress().getStreet());
            address.setZip_code(companyVO.getAddress().getZip_code());

        }else {
            address = addressDAO.findById(companyVO.getAddress().getId()).orElse(null);
        }
        Company company = new Company();
        company.setName(companyVO.getNome());
        company.setDocument(companyVO.getDocumento());
        company.setVacancies(companyVO.getVagas());
        company.setSite(companyVO.getSite());
        company.setAddress(address);
        Company company1 = companyDAO.save(company);
        return CompanyVO.builder()
                .id(company1.getId())
                .nome(company1.getName())
                .documento(company1.getDocument())
                .site(company1.getSite())
                .vagas(company1.getVacancies())
                .address(AddressVO.builder()
                        .id(company1.getAddress().getId())
                        .city(company1.getAddress().getCity())
                        .country(company1.getAddress().getCountry())
                        .district(company1.getAddress().getDistrict())
                        .number(company1.getAddress().getNumber())
                        .street(company1.getAddress().getStreet())
                        .zip_code(company1.getAddress().getZip_code())
                        .build())
                .build();
    }

    @Override
    @Transactional
    public void deleteCompany(Long id) {
        companyDAO.deleteById(id);
    }

    @Override
    public List findAllByNameOrderByName(String name) {

        return companyDAO.findAllByNameOrderByName(name);
    }

    @Override
    public List listUserName() {
        return userDAO.buscarUsuario();
    }

    public Integer getCompanyCount(){
        return companyDAO.getCompanyCount();
    }

    @Override
    public List<Company> listCompanyName(String name){
        return companyDAO.buscarCompany(name);
    }
}
