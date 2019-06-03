package com.expedia.validator.services;


import com.expedia.validator.entity.BlackList;
import com.expedia.validator.manager.ValidationManager;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ValidatorServiceTest {

    private ValidatorService validatorService;
    private ValidationManager validationManager;

    @Before
    public void setUp() {
        validationManager = mock(ValidationManager.class);
        validatorService = new ValidatorService(validationManager);
    }

    @Test
    public void test_getBlackList_success() {
        doReturn(getBlackList(false)).when(validationManager).getBlackList();
        Response response  = validatorService.getCardBlacklist();
        assertTrue(response.getEntity() instanceof BlackList);
        assertEquals(2, ((BlackList) response.getEntity()).getBlacklist().size());
    }


    @Test
    public void test_getBlackList_failure() {
        doReturn(getBlackList(true)).when(validationManager).getBlackList();
        Response response  = validatorService.getCardBlacklist();
        assertNull(response.getEntity());
    }

    private BlackList getBlackList(boolean failure) {
        BlackList blackList = null;
        if(!failure) {
            blackList = new BlackList();
            List<String> cards = new ArrayList<>();
            cards.add("4788 3845 3855 2446");
            cards.add("5144 3854 3852 3845");
            blackList.setBlacklist(cards);
        }
        return blackList;
    }
}
