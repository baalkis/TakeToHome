package com.TakeToHome.userservice.controller;

import java.util.List;
import javax.validation.Valid;

import com.TakeToHome.userservice.VO.CreditCard;
import com.TakeToHome.userservice.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.TakeToHome.userservice.exception.dao.UserRepository;
import com.TakeToHome.userservice.model.User;
import com.TakeToHome.userservice.model.Response;
import com.TakeToHome.userservice.service.UserService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final String User_CARD_SAVED_SUCCESSFULLY = "User Card saved successfully.";
    private static final String V_CHECK_VALIDATION_FAILED_INVALID_CREDIT_CARD_NUMBER = " check validation failed. Invalid Credit Card Number in input.";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/saveUser", produces = { "application/json" })
    public Response saveUser(@Valid @RequestBody User user) {
        String pass = userService.EncryptUserPassword(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        return new Response(HttpStatus.OK, User_CARD_SAVED_SUCCESSFULLY);

    }
    @GetMapping("/{name}")
    public ResponseTemplateVO getUserWithCreditCard(@PathVariable("name") String name){
        ResponseTemplateVO vo=new ResponseTemplateVO();
        new Response(HttpStatus.OK,"inside getUserWithCreditCard");
        User user=userRepository.findByName(name);
        CreditCard creditCard= restTemplate.getForObject("http://CREDITCARD/creditcards/" + user.getName(),CreditCard.class) ;
        vo.setUser(user);
        vo.setCreditCard(creditCard);
        return vo;

    }
    @GetMapping("/getAllUser")
    public List<User> getAll() {
        return userRepository.findAll();
    }


}
