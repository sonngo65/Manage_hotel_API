package com.example.ShopWebAPI.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ShopWebAPI.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{

}
