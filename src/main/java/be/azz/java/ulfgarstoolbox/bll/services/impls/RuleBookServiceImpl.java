package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.IRuleBookService;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.ruleBook.RuleBookNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.RuleBookMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.RuleBookRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.RuleBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleBookServiceImpl implements IRuleBookService {

    private final RuleBookRepository ruleBookRepository;
    private final RuleBookMapper ruleBookMapper;

    @Override
    public List<RuleBookShortResponse> getAllRuleBooks() {
        return ruleBookRepository.findAll()
                .stream()
                .map(ruleBookMapper::fromEntityToShort)
                .toList();
    }

    @Override
    public RuleBookResponse getRuleBookById(Long id) {
        RuleBook ruleBook = ruleBookRepository.findById(id).orElseThrow(RuleBookNotFoundException::new);
        return ruleBookMapper.fromEntityToDetail(ruleBook);
    }
}
