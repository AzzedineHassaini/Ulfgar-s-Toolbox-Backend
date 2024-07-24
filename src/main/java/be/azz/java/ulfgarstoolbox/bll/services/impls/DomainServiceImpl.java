package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.IDomainService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.domain.requests.DomainRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.domain.responses.DomainResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.AlreadyExistsException;
import be.azz.java.ulfgarstoolbox.common.exceptions.domain.DomainNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.DomainMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.DomainRepository;
import be.azz.java.ulfgarstoolbox.dal.specifications.DomainSpecification;
import be.azz.java.ulfgarstoolbox.domain.entities.Domain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements IDomainService {

    private final DomainRepository domainRepository;
    private final DomainMapper domainMapper;

    @Override
    public PagedResponse<DomainResponse> findAll(Map<String, String> params, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Domain> pagedDomains = domainRepository
                .findAll(DomainSpecification.filterByParams(params), pageable);

        return domainMapper.fromPage(pagedDomains);
    }

    @Override
    public DomainResponse findById(Integer id) {
        Domain domain = domainRepository.findById(id).orElseThrow(DomainNotFoundException::new);

        return domainMapper.fromEntity(domain);
    }

    @Override
    public DomainResponse findByName(String domainName) {
        Domain domain = domainRepository.findByDomainName(domainName).orElseThrow(DomainNotFoundException::new);

        return domainMapper.fromEntity(domain);
    }

    @Override
    public DomainResponse addDomain(DomainRequest request) {
        if (domainRepository.findByDomainName(request.name()).isPresent()) {
            throw new AlreadyExistsException("Domain already exists");
        }

        Domain domain = domainMapper.toEntity(request);

        return domainMapper.fromEntity(domainRepository.save(domain));
    }

    @Override
    public DomainResponse updateDomain(Integer id, DomainRequest request) {
        Domain existingDomain = domainRepository.findById(id).orElseThrow(DomainNotFoundException::new);

        domainMapper.updateEntityFromRequest(request, existingDomain);

        return domainMapper.fromEntity(domainRepository.save(existingDomain));
    }

    @Override
    public DomainResponse deleteDomain(Integer id) {
        Domain domain = domainRepository.findById(id).orElseThrow(DomainNotFoundException::new);

        domainRepository.delete(domain);

        return domainMapper.fromEntity(domain);
    }

}
