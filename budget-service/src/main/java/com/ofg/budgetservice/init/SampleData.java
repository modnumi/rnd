package com.ofg.budgetservice.init;

import com.ofg.budgetservice.model.Entry;
import com.ofg.budgetservice.model.Transaction;
import com.ofg.budgetservice.model.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static com.ofg.budgetservice.model.Entry.EntryType.EXPENSE;
import static com.ofg.budgetservice.model.Entry.EntryType.INCOME;

@Component
public class SampleData implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    @Autowired
    public SampleData(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        transactionRepository.save(income());
        transactionRepository.save(expense(new BigDecimal(50)));
        transactionRepository.save(expense(new BigDecimal(30)));
        transactionRepository.save(expense(new BigDecimal(15)));

        transactionRepository.findAll().forEach(System.out::println);
    }

    private Transaction income() {
        Transaction income = new Transaction("Income", new Date());
        income.addEntry(new Entry(INCOME, new BigDecimal(1000)));
        return income;
    }

    private Transaction expense(BigDecimal amount) {
        Transaction income = new Transaction("Expense", new Date());
        income.addEntry(new Entry(EXPENSE, amount));
        return income;
    }
}
