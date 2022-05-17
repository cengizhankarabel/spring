package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;

public class App {
	public static void main(String[] args) {

		// init / boot phase
		AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
		AccountRepository jpaAccountRepository = new JpaAccountRepository();
		TransferService transferService = new TransferServiceImpl(jdbcAccountRepository);

		// use phase
		transferService.transfer(300, "1", "2");
		System.out.println();
		transferService.transfer(300, "1", "2");

		// destroy phase
		transferService = null;
	}
}
