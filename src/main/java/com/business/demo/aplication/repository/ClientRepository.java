package com.business.demo.aplication.repository;

import com.business.demo.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Optional<Client> findById(Integer id);
    Optional<Client> findByEmail(String email);
    Client save(Client client);
    void delete(Client client);
}
