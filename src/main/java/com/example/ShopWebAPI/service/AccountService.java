package com.example.ShopWebAPI.service;

import java.util.List;

import com.example.ShopWebAPI.entity.Account;

public interface AccountService {
	Account add(Account acc);
	Account remove(Account acc); 
	Account update(Account acc);
	List<Account> listAll();
	Account changePassword(Account account,String password);
}
