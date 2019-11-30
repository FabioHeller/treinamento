package com.codenation.treinamento.service;

import com.codenation.treinamento.entity.Company;
import com.codenation.treinamento.vo.CompanyVO;
import com.codenation.treinamento.vo.UserVO;

import java.util.List;

public interface CompanyService {
    public CompanyVO createCompany(CompanyVO companyVO);
    public void deleteCompany(Long id);
    public List<Company> listCompanyName(String name);
    public List<CompanyVO> findAllByNameOrderByName(String name);
    public List<UserVO> listUserName();
}
