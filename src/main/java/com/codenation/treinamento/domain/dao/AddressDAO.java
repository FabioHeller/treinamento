package com.codenation.treinamento.domain.dao;

import com.codenation.treinamento.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Long> {
}
