package com.TakeToHome.creditcard.service;

import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    public static boolean validateCreditCardNumber(String str) {
        /**
         * Get String
         * @return boolean
         * This method checks if the string passed in passes the Luhn 10 check
         **/

        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }

        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

}