package com.btcjava.spring.service;

import java.util.List;

import com.btcjava.spring.bean.Bitcoin;

public interface BitcoinService {
	public void createBitcoin(Bitcoin bitcoin);
	public List<Bitcoin> getBitcoin();
	public Bitcoin findById(int id);
}
