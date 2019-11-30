package com.codenation.treinamento.domain.dao;

import com.codenation.treinamento.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query(value = "UPDATE user set name :name WHERE id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("name")String name);

    @Query(value = "UPDATE user set company_id :idCompany WHERE id = :idUser", nativeQuery = true)
    void alterCompanyUser(@Param("idUser") Long idUser, @Param("idCompany")Long idCompany);

    @Query(value = "SELECT * FROM user;", nativeQuery = true)
    List<User> buscarUsuario();
}
