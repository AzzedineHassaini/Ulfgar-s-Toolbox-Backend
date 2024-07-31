package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.RuleBook;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RuleBookMapper {

    RuleBookShortResponse fromEntityToShort(RuleBook entity);

    RuleBookResponse fromEntityToDetail(RuleBook entity);

}
