package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

import persistance.domain.Account;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String accountJSON) {
		Account newAccount = util.getObjectForJSON(accountJSON, Account.class);
		Account accountInDB = findAccount(newAccount.getUserName());
		if (accountInDB != null) {
			return "{\"message\": \"username is already taken\"}";
			}
		else {
			manager.persist(newAccount);
			return "{\"message\": \"account has been sucessfully added\"}";
		}
	}
	
	
	@Transactional(REQUIRED)
	public String updateAccount(String username,String accountJSON) {
		Account accountInDB = findAccount(username);
		Account newAccount = util.getObjectForJSON(accountJSON, Account.class);
		if (accountInDB.getUserName() == newAccount.getUserName()) {
			return "{\"message\": \"username is already taken \"}";
			}
		else {
			manager.remove(accountInDB);
			manager.persist(newAccount);
			return "{\"message\": \"has been sucessfully updated\"}";
			}
	}
	
	
	@Transactional(REQUIRED)
	public String deleteAccount(String username) {
		Account accountInDB = findAccount(username);
		if (accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
			}
		return "{\"message\": \"deletion did not work\"}";
	}

	
	private Account findAccount(String username) {
		return manager.find(Account.class, username);
	}
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
