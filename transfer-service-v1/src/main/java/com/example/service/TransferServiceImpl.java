package com.example.service;


import com.example.model.Account;
import com.example.repository.JdbcAccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransferServiceImpl {
	
	public TransferServiceImpl() {
		log.info("TransferServiceImpl instance created...");
	}
	

	public void transfer(double amount, String fromAccNum, String toAccNum) {
		log.info("transfer initiated..");

		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);
		
		log.info("transfer finished..");

	}
}
