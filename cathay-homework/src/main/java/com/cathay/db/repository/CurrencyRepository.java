package com.cathay.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cathay.db.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
