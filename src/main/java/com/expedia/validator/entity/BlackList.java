package com.expedia.validator.entity;

import java.util.List;

/**
 * Java representation of the BlackList.json file
 */
public class BlackList {

    List<String> blacklist;

    public List<String> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<String> blacklist) {
        this.blacklist = blacklist;
    }
}
