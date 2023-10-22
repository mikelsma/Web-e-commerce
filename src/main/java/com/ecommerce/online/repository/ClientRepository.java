package com.ecommerce.online.repository;

import com.ecommerce.online.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
