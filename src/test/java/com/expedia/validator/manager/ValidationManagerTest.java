package com.expedia.validator.manager;

import com.expedia.validator.entity.CardInfo;
import com.expedia.validator.enums.CardType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ValidationManagerTest {

    private ValidationManager validationManager;

    @Before
    public void setUp() {
        this.validationManager = new ValidationManager();
    }

    @Test
    public void test_validateCard_visa() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("4111 1111 1111 1111");
            setExpiryDate("11/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertTrue(result.getIsValid());
        assertEquals(CardType.VISA, result.getCardType());
        assertEquals("Card is valid", result.getMessage());
    }

    @Test
    public void test_validateCard_mastercard() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("5500 0000 0000 0004");
            setExpiryDate("10/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertTrue(result.getIsValid());
        assertEquals(CardType.MASTERCARD, result.getCardType());
        assertEquals("Card is valid", result.getMessage());
    }

    @Test
    public void test_validateCard_otherCard() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("1200 1111 0000 1234");
            setExpiryDate("12/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertFalse(result.getIsValid());
        assertEquals(CardType.UNKNOWN, result.getCardType());
        assertEquals("Invalid card number or expiry date", result.getMessage());
    }

    @Test
    public void test_validateCard_blacklist_visa() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("4012 8888 8888 1881");
            setExpiryDate("12/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertFalse(result.getIsValid());
        assertEquals(CardType.VISA, result.getCardType());
        assertEquals("The card is blacklisted", result.getMessage());
    }

    @Test
    public void test_validateCard_blacklist_mastercard() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("5555 5555 5555 4444");
            setExpiryDate("12/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertFalse(result.getIsValid());
        assertEquals(CardType.MASTERCARD, result.getCardType());
        assertEquals("The card is blacklisted", result.getMessage());
    }

    @Test
    public void test_validateCard_invalid_expiryDate() {
        CardInfo cardInfo = new CardInfo(){{
            setCardNumber("5555 5555 5555 4444");
            setExpiryDate("12-19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertFalse(result.getIsValid());
        assertEquals(CardType.MASTERCARD, result.getCardType());
        assertEquals("Invalid card number or expiry date", result.getMessage());
    }

    @Test
    public void test_validateCard_invalid_expiryDate_smaller() {
        CardInfo cardInfo = new CardInfo() {{
            setCardNumber("5555 5555 5555 4444");
            setExpiryDate("01/19");
        }};

        CardInfo result = validationManager.validateCard(cardInfo);
        assertNotNull(result);
        assertFalse(result.getIsValid());
        assertEquals(CardType.MASTERCARD, result.getCardType());
        assertEquals("Invalid card number or expiry date", result.getMessage());
    }
}
