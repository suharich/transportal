package edu.khnahu.controller;

import java.util.List;

import java.text.ParseException;

import edu.khnahu.domain.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.khnahu.repository.*;
import java.util.ArrayList;


@RestController
public class AccountManagerController {

    public AccountManagerController(){}

    public AccountManagerController(AccountRepository injectedRepo) {
        accountRepository = injectedRepo;
    }

    @Autowired
    private AccountRepository accountRepository;
	
	 @RequestMapping(value="/accounts",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Account> getAllAccounts() {

         // uncomment if you need remove all and create new collection
         // accountRepository.deleteAll();

         if (accountRepository.count() == 0) {
             // adds test data
             int c = 0;
             while (c++ < 2) {
                 Account account = new Account();
                 //task.setTaskId(c);
                 account.setLoggin("demoAcc" + c);
                 account.setEmail("demoAcc" + c + "@khnahu.edu");
                 if (c % 2 == 0) {
                     account.setAccType("HIGH");
                     account.setAccStatus("COMPLETED");
                 }
                 else {
                     account.setAccType("MEDIUM");
                     account.setAccStatus("ACTIVE");
                 }

                 accountRepository.save(account);
             }
         }
	  return accountRepository.findAll();
	
	 }
	 
	 
	 @RequestMapping(value="/accounts/archive/{accIds}",method = RequestMethod.POST,headers="Accept=application/json")
     public List<Account> archiveAllAccounts(@PathVariable String[] accIds) {
		 for(int i=0; i<accIds.length; i++){
             accountRepository.delete(accIds[i]);
			 
		 }
	  List<Account> accounts = accountRepository.findAll();
	  return accounts;
	
	 }
	 
	 @RequestMapping(value="/accounts/{accId}/{accStatus}",method = RequestMethod.POST,headers="Accept=application/json")
     public List<Account> changeAccountStatus(@PathVariable String accId,@PathVariable String accStatus) throws ParseException {
         Account account = ((AccountRepositoryCustom) accountRepository).findById(accId);
         account.setAccStatus(accStatus);
         accountRepository.save(account);

         List<Account> res = new ArrayList<Account>();
         res.add(account);

         // shows the only one task
		 //return res;
         return accountRepository.findAll();
		 
	 }
	 
	 @RequestMapping(value="/accounts/insert/{loggin}/{email}/{accType}/{accStatus}",method = RequestMethod.POST,headers="Accept=application/json")
     public List<Account> addAccount(@PathVariable String loggin,@PathVariable String email,@PathVariable String accType,@PathVariable String accStatus) throws ParseException {
         Account account = new Account();
		 account.setLoggin(loggin);
		 account.setEmail(email);
		 account.setAccType(accType);
		 account.setAccStatus(accStatus);
         accountRepository.save(account);
		return accountRepository.findAll();
		 
	 }
}