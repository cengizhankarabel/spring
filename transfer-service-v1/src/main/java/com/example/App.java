package com.example;

import com.example.model.Account;
import com.example.service.TransferServiceImpl;

public class App {
	public static void main(String[] args) {
		
		// init / boot phase
		TransferServiceImpl transferService = new TransferServiceImpl();
		
		//use phase
		transferService.transfer(300, "1", "2");
		
		// destroy phase
		transferService= null;
	}
}
