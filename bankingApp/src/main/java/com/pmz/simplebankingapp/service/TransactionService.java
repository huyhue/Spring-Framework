package com.pmz.simplebankingapp.service;

import com.pmz.simplebankingapp.domain.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findTransactionsByCardId(long id);
}
