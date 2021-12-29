package com.TakeToHome.creditcard.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.TakeToHome.creditcard.exception.dao.CreditCardRepository;
import com.TakeToHome.creditcard.model.CreditCard;
import com.TakeToHome.creditcard.model.Response;
import com.TakeToHome.creditcard.service.CreditCardService;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    private static final String CREDIT_CARD_SAVED_SUCCESSFULLY = "Credit Card saved successfully.";
    private static final String V_CHECK_VALIDATION_FAILED_INVALID_CREDIT_CARD_NUMBER = " check validation failed. Invalid Credit Card Number in input.";

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping(value = "/saveCreditCard", produces = { "application/json" })
    public Response saveCreditCard(@Valid @RequestBody CreditCard creditcard) {
        Boolean pass = creditCardService.validateCreditCardNumber(creditcard.getCreditCardNumber());
        if (pass == true) {
            repository.save(creditcard);
            return new Response(HttpStatus.OK, CREDIT_CARD_SAVED_SUCCESSFULLY);
        } else {
            return new Response(HttpStatus.BAD_REQUEST, V_CHECK_VALIDATION_FAILED_INVALID_CREDIT_CARD_NUMBER);
        }
    }
    @GetMapping("/{name}")
    public CreditCard findCreditCardByName(@PathVariable("name") String name ){
        return repository.findCreditCardByName(name);
    }

    @GetMapping("/getAllCreditCards")
    public List<CreditCard> getAll() {
        return repository.findAll();
    }

}
