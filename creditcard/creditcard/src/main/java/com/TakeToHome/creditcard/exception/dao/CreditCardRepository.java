package com.TakeToHome.creditcard.exception.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TakeToHome.creditcard.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, String>{

    CreditCard findCreditCardByName(String name);
}
