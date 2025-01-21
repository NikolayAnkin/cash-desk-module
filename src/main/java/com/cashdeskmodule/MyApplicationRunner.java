package com.cashdeskmodule;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cashdeskmodule.balance.Balance;
import com.cashdeskmodule.balance.BalanceRepository;
import com.cashdeskmodule.cashier.Cashier;
import com.cashdeskmodule.cashier.CashierRepository;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	private final CashierRepository cashierRepository;
	private final BalanceRepository balanceRepository;

	public MyApplicationRunner(CashierRepository cashierRepository, BalanceRepository balanceRepository) {

		this.cashierRepository = cashierRepository;
		this.balanceRepository = balanceRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Martina
		Cashier martina = new Cashier();
		martina.setCashierId(1L);
		martina.setCashierName("Martina");
		martina.setCashierAddress("Paris, Rue Cler");
		martina.setCashierContact("martina@abv.bg");

		Balance balanceBgnMartina = new Balance();
		balanceBgnMartina.setBalanceId(1L);
		balanceBgnMartina.setCashierId(1L);
		balanceBgnMartina.setCashierName("Martina");
		balanceBgnMartina.setCurrency("BGN");
		balanceBgnMartina.setBalanceAmount(1000);
		Map<Integer, Integer> denominationsBgnMartina = new HashMap<Integer, Integer>();
		denominationsBgnMartina.put(50, 10);
		denominationsBgnMartina.put(10, 50);
		balanceBgnMartina.setDenominations(denominationsBgnMartina);
		martina.getBalances().add(balanceBgnMartina);

		Balance balanceEurMartina = new Balance();
		balanceEurMartina.setBalanceId(2L);
		balanceEurMartina.setCashierId(1L);
		balanceEurMartina.setCashierName("Martina");
		balanceEurMartina.setCurrency("EUR");
		balanceEurMartina.setBalanceAmount(2000);
		Map<Integer, Integer> denominationsEurMartina = new HashMap<Integer, Integer>();
		denominationsEurMartina.put(10, 100);
		denominationsEurMartina.put(50, 20);
		balanceEurMartina.setDenominations(denominationsEurMartina);
		martina.getBalances().add(balanceEurMartina);

		cashierRepository.save(martina);
		balanceRepository.save(balanceBgnMartina);
		balanceRepository.save(balanceEurMartina);

		// Peter
		Cashier peter = new Cashier();
		peter.setCashierId(2L);
		peter.setCashierName("Peter");
		peter.setCashierAddress("Paris, Rue Cler");
		peter.setCashierContact("peter@abv.bg");

		Balance balanceBgnPeter = new Balance();
		balanceBgnPeter.setBalanceId(3L);
		balanceBgnPeter.setCashierId(2L);
		balanceBgnPeter.setCashierName("Peter");
		balanceBgnPeter.setCurrency("BGN");
		balanceBgnPeter.setBalanceAmount(1000);
		Map<Integer, Integer> denominationsBgnPeter = new HashMap<Integer, Integer>();
		denominationsBgnPeter.put(50, 10);
		denominationsBgnPeter.put(10, 50);
		balanceBgnPeter.setDenominations(denominationsBgnPeter);
		peter.getBalances().add(balanceBgnPeter);

		Balance balanceEurPeter = new Balance();
		balanceEurPeter.setBalanceId(4L);
		balanceEurPeter.setCashierId(2L);
		balanceEurPeter.setCashierName("Peter");
		balanceEurPeter.setCurrency("EUR");
		balanceEurPeter.setBalanceAmount(2000);
		Map<Integer, Integer> denominationsEurPeter = new HashMap<Integer, Integer>();
		denominationsEurPeter.put(10, 100);
		denominationsEurPeter.put(50, 20);
		balanceEurPeter.setDenominations(denominationsEurPeter);
		peter.getBalances().add(balanceEurPeter);

		cashierRepository.save(peter);
		balanceRepository.save(balanceBgnPeter);
		balanceRepository.save(balanceEurPeter);

		// Linda
		Cashier linda = new Cashier();
		linda.setCashierId(3L);
		linda.setCashierName("Linda");
		linda.setCashierAddress("Paris, Rue Cler");
		linda.setCashierContact("linda@abv.bg");

		Balance balanceBgnLinda = new Balance();
		balanceBgnLinda.setBalanceId(5L);
		balanceBgnLinda.setCashierId(3L);
		balanceBgnLinda.setCashierName("Linda");
		balanceBgnLinda.setCurrency("BGN");
		balanceBgnLinda.setBalanceAmount(1000);
		Map<Integer, Integer> denominationsBgnLinda = new HashMap<Integer, Integer>();
		denominationsBgnLinda.put(50, 10);
		denominationsBgnLinda.put(10, 50);
		balanceBgnLinda.setDenominations(denominationsBgnLinda);
		linda.getBalances().add(balanceBgnLinda);

		Balance balanceEurLinda = new Balance();
		balanceEurLinda.setBalanceId(6L);
		balanceEurLinda.setCashierId(3L);
		balanceEurLinda.setCashierName("Linda");
		balanceEurLinda.setCurrency("EUR");
		balanceEurLinda.setBalanceAmount(2000);
		Map<Integer, Integer> denominationsEurLinda = new HashMap<Integer, Integer>();
		denominationsEurLinda.put(10, 100);
		denominationsEurLinda.put(50, 20);
		balanceEurLinda.setDenominations(denominationsEurLinda);
		linda.getBalances().add(balanceEurLinda);

		cashierRepository.save(linda);
		balanceRepository.save(balanceBgnLinda);
		balanceRepository.save(balanceEurLinda);

	}

}
