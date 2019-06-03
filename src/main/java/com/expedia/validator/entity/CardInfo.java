package com.expedia.validator.entity;

import com.expedia.validator.enums.CardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Card Info class used to handle the card details
 * and statuses in the web service
 */
@ApiModel(value = "CardInfo", description = "CardInfo model used to hold card details")
public class CardInfo {

    @ApiModelProperty(value = "String representation of Credit Card", required = true)
    private String cardNumber;
    @ApiModelProperty(value = "String representation of Credit Card expiry Date", required = true)
    private String expiryDate;
    @ApiModelProperty(value = "Status of the card after validating")
    private boolean isValid;
    @ApiModelProperty(value = "Enum representing the Card Type (only Visa or Master for now!)")
    private CardType cardType;
    @ApiModelProperty(value = "Message after validating the Credit Card.")
    private String message;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
