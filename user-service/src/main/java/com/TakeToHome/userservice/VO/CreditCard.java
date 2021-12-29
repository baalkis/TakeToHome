package com.TakeToHome.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreditCard {
    @Id
    @Length(max = 19, message = "Credit Card Number must not be greater than 19 characters")
    @Digits(integer = 30, fraction = 0, message = "Credit Card Number must only be numeric")
    private String creditCardNumber;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String securityCode;

    private Date expiration;

    private float maxCredit;

    private float availableCredit;

    private boolean status;
}
