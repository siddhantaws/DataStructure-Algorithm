package com.wfs.design.account;

import com.wfs.design.bo.Question;
import com.wfs.design.constant.AccountType;

public class Moderator extends Member {

    public Moderator() {
        super(AccountType.MODERATOR);
    }

    public boolean closeQuestion(Question question) {
        return false;
    }

    public boolean undeleteQuestion(Question question) {
        return false;
    }

}