package com.codenation.treinamento.service.impl;

import com.codenation.treinamento.domain.dao.CompanyDAO;
import com.codenation.treinamento.domain.dao.UserDAO;
import com.codenation.treinamento.entity.Company;
import com.codenation.treinamento.entity.User;
import com.codenation.treinamento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CompanyDAO companyDAO;
   // @Metodos(text = ("Nome do metodo é: "))
    @Autowired
   UserDAO userDao;

    @Override
    @Transactional
    public void createUser(String nome, String documento, int age, String login, String password, Long company_id, BigDecimal salary) {
        Company company = companyDAO.getOne(company_id);
        User user = new User();
        user.setName(nome);
        user.setDocument(documento);
        user.setAge(age);
        user.setLogin(login);
        user.setPassword(password);
        user.setComapany(company);
        user.setSalary(salary);
        userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public void upadateNameUser(Long id, String name) {
        userDao.update(id, name);
    }

    @Override
    public void alterCompanyUser(Long idUser, Long idCompany) {
        userDao.alterCompanyUser(idUser, idCompany);
    }
}
