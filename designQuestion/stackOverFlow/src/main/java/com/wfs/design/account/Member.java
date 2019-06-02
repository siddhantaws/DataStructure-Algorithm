package com.wfs.design.account;

import com.wfs.design.bo.Badge;
import com.wfs.design.bo.Question;
import com.wfs.design.constant.TagType;
import com.wfs.design.bo.Tag;
import com.wfs.design.constant.AccountType;
import com.wfs.design.repo.QuestionRepository;
import com.wfs.design.repo.TagRepo;

import java.util.List;

public abstract class Member {

  private Account account;
  private AccountType accountType;
  private List<Badge> badges;
  private TagRepo tagRepo;
  private QuestionRepository questionRepository;

  public Member(AccountType accountType) {
    this.accountType = accountType;
  }

  public int getReputation(){
      return 0;
  }
  public String getEmail() {
    return account.getEmail();
  }

  public boolean createQuestion(Question question){
    question.setAskingMember(this);
    return this.questionRepository.addQuestion(question);
  }

  public boolean createTag(Tag tag){
    return tagRepo.createTag(TagType.valueOf(tag.getName()) , tag);
  }
}