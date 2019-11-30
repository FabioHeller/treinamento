package com.codenation.treinamento.domain.dao;

import com.codenation.treinamento.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyDAO extends JpaRepository<Company, Long> {
    @Query(value = "SELECT * FROM company WHERE name like :name ORDER BY name", nativeQuery = true)
    List<Company> buscarCompany(@Param("name") String name);

    List<Company> findAllByNameOrderByName(@Param("name") String name);

    @Query("SELECT count(*) FROM company")
    Integer getCompanyCount();

}
