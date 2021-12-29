package com.TakeToHome.creditcard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @Length(max = 19, message = "Credit Card Number must not be greater than 19 characters")
    @Digits(integer = 30, fraction = 0, message = "Credit Card Number must only be numeric")
    private String creditCardNumber;
    private String email;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String securityCode;

    private Date expiration;

    private float maxCredit;

    private float availableCredit;

    private boolean status;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public float getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(float maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public float getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(float availableCredit) {
        this.availableCredit = availableCredit;
    }
}
