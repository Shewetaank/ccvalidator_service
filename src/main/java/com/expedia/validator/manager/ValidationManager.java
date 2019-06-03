package com.expedia.validator.manager;

import com.expedia.validator.entity.BlackList;
import com.expedia.validator.entity.CardInfo;
import com.expedia.validator.enums.CardType;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.expedia.validator.enums.CardType.getCardType;
import static com.expedia.validator.helper.CardHelper.*;
import static com.expedia.validator.helper.CardHelper.trimCardNumber;
import static com.expedia.validator.helper.FileReader.getFile;
import static java.util.Objects.nonNull;

@Component
public class ValidationManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationManager.class);
    private static final int ALLOWED_CARD_LENGTH = 16;

    public ValidationManager() {
    }

    /**
     * Check if the card is valid
     * @param cardInfo
     * @return cardInfo with status and card type
     */
    public CardInfo validateCard(CardInfo cardInfo) {
        Preconditions.checkNotNull(cardInfo);
        cardInfo.setCardNumber(trimCardNumber(cardInfo.getCardNumber()));
        cardInfo.setCardType(getCardType(cardInfo.getCardNumber()));
        if (cardInfo.getCardType() != CardType.UNKNOWN && isValidExpiryDate(cardInfo.getExpiryDate())
                && luhnCheck(cardInfo.getCardNumber()) && cardInfo.getCardNumber().length() == ALLOWED_CARD_LENGTH) {
            if(notInBlackList(cardInfo.getCardNumber())) {
                cardInfo.setIsValid(true);
                cardInfo.setMessage("Card is valid");
            } else {
                cardInfo.setIsValid(false);
                cardInfo.setMessage("The card is blacklisted");
            }
        } else {
            cardInfo.setIsValid(false);
            cardInfo.setMessage("Invalid card number or expiry date");
        }
        return cardInfo;
    }

    /**
     * Get cards blacklist
     * @return blackList
     */
    public BlackList getBlackList() {
        BlackList blackList = null;
        try {
            String jsonData = getFile("blacklist.json");
            if (!StringUtils.isEmpty(jsonData)) {
                Gson gson = new Gson();
                blackList = gson.fromJson(jsonData, BlackList.class);
            }

        } catch (Exception ex) {
            LOGGER.error("Error while getting the blacklist cards");
        }
        return blackList;
    }

    /**
     * Check whether the card is in blacklist
     * @param cardNumber
     * @return
     */
    private boolean notInBlackList(String cardNumber) {
        boolean status = true;
        BlackList blackList = getBlackList();
        if (nonNull(blackList)) {
            for (String cb:
                 blackList.getBlacklist()) {
                if(trimCardNumber(cb).equals(cardNumber)) {
                    status = false;
                }
            }
        }
        return status;
    }
}
