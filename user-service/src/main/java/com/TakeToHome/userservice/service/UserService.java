package com.TakeToHome.userservice.service;

import com.TakeToHome.userservice.VO.ResponseTemplateVO;
import com.TakeToHome.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    public String EncryptUserPassword(String password) {
        //don't miss to insert a crypt-algo for password
        return password;

    }


}
