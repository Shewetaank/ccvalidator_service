package com.expedia.validator.helper;

import org.springframework.util.StringUtils;

import java.time.LocalDate;

import static java.util.Objects.nonNull;

public class CardHelper {

    /**
     * Trim the card Number
     * @param cardNumber
     * @return
     */
    public static String trimCardNumber(String cardNumber) {
        return cardNumber.replaceAll("\\s+", "");
    }

    /**
     * Check if the expiry date is valid
     *
     * @param expiryDate
     * @return
     */
    public static boolean isValidExpiryDate(String expiryDate) {
        boolean status = false;
        if (nonNull(expiryDate) && !StringUtils.isEmpty(expiryDate) && expiryDate.length() == 5) {
            String[] dateArray = expiryDate.split("/");
            if (dateArray.length == 2) {
                int month = Integer.parseInt(dateArray[0]);
                int year = Integer.parseInt(dateArray[1]);
                LocalDate localDate = LocalDate.now();
                if (year > (localDate.getYear() % 100)) {
                    status = true;
                } else if (year == (localDate.getYear() % 100)) {
                    if(month > localDate.getMonth().getValue())
                        status = true;
                }
            }
        }
        return status;
    }

    /**
     * Perform luhn check for the last digit
     *
     * @param cardNumber
     * @return
     */
    public static boolean luhnCheck(String cardNumber) {
        int sum = 0;
        boolean next = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (next) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            next = !next;
        }
        return (sum % 10 == 0);
    }
}
