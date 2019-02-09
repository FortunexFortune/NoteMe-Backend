package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Account;
import com.qa.persistance.repository.AccountRepository;
import com.qa.util.JSONUtil;


public class AccountServiceImpl implements AccountService {
	
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;

	
	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.getAllAccounts();
	}

	public String createAccount(String accountJSON) {
		Account newAccount = util.getObjectForJSON(accountJSON, Account.class);
		//prevents spaces in UserName
		for (char i : newAccount.getUserName().toCharArray()) {
			if ( i == ' ')  {
				return "{\"message\": \"account can not be added\"}";			
			}
		}
		//prevents null UserName
		if ( (newAccount.getUserName().equals(""))) {
			return "{\"message\": \"account can not be added\"}";
		}
		//prevents null Passwords
		if ( (newAccount.getPwd().equals(""))) {
			return "{\"message\": \"account can not be added\"}";			
		}
		return repo.createAccount(accountJSON);
	}
	
	
	
	public String updateAccount(String username, String accountJSON) {
		// TODO Auto-generated method stub
		return repo.updateAccount(username,accountJSON);
	}

	public String deleteAccount(String username) {
		// TODO Auto-generated method stub
		return repo.deleteAccount(username);
	}
	
	public String getAccount(String username) {
		// TODO Auto-generated method stub
		return repo.getAccount(username);
	}
	
	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}





}
