package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
//		http://localhost:8080/SpeedMe_Backend/api/account/getAllAccounts
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String accountJSON) {
//		http://localhost:8080/SpeedMe_Backend/api/account/createAccount
		return service.createAccount(accountJSON);
	}

	@Path("/deleteAccount/{username}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("username") String username) {
//		http://localhost:8080/SpeedMe_Backend/api/account/deleteAccount/1
		return service.deleteAccount(username);
	}
	
	@Path("/updateAccount/{username}")
	@POST
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("username") String username,String accountJSON) {
//		http://localhost:8080/SpeedMe_Backend/api/account/updateAccount/3
		return service.updateAccount(username,accountJSON);
	}

	public void setService(AccountService service) {
		this.service = service;
	}

}
