package com.codenation.treinamento.service;

import com.codenation.treinamento.annotation.Metodos;
import com.codenation.treinamento.entity.Company;
import com.codenation.treinamento.entity.User;

import java.math.BigDecimal;

public interface UserService {
    public void createUser(String nome, String documento, int age, String login,
                           String password, Long company_id, BigDecimal salary);
    public void deleteUser(Long id);
    //`name`, `document`, `age`, `login`, `password`, `company_id`, `salary`,`address_id`

    public void upadateNameUser(Long id, String name);

    public void alterCompanyUser(Long idUser, Long idCompany);
}
