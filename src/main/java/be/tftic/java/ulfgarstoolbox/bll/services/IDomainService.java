package be.tftic.java.ulfgarstoolbox.bll.services;

import be.tftic.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.requests.DomainRequest;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.responses.DomainResponse;

import java.util.Map;

public interface IDomainService {

    PagedResponse<DomainResponse> findAll(Map<String, String> params, int page, int pageSize);

    DomainResponse findById(Integer id);

    DomainResponse findByName(String domainName);

    DomainResponse addDomain(DomainRequest request);

    DomainResponse updateDomain(Integer id, DomainRequest request);

    DomainResponse deleteDomain(Integer id);
}
