package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookShortResponse;

import java.util.List;

public interface IRuleBookService {

    List<RuleBookShortResponse> getAllRuleBooks();

    RuleBookResponse getRuleBookById(Long id);

}
