package com.example.ShopWebAPI.service.impl;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.ShopWebAPI.entity.Account;
import com.example.ShopWebAPI.exception.ResourceNotFoundException;
import com.example.ShopWebAPI.repository.AccountRepository;
import com.example.ShopWebAPI.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private final AccountRepository accountRepository;
	
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@Override
	public Account add(Account acc) {
		Account addedAccount  = accountRepository.save(acc);
		return addedAccount;
	}

	@Override
	public Account remove(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account acc) {
		Account addedAccount = accountRepository.findById(acc.getId()).orElseThrow(()-> new ResourceNotFoundException("Account","id",acc.getId().toString()));
		
		Account updatedAccount = accountRepository.save(acc);
		
		return updatedAccount;
	}


	@Override
	public List<Account> listAll() {
		List<Account> accounts = accountRepository.findAll();
		return  accounts;
	}


	@Override
	public Account changePassword(Account acc,String password) {
		Account addedAccount = accountRepository.findById(acc.getId()).orElseThrow(()-> new ResourceNotFoundException("Account","id",acc.getId().toString()));
		addedAccount.setPassword(password);
		Account passwordChangedAccount =  accountRepository.save(addedAccount);
		return passwordChangedAccount;
	}
	
	



}
