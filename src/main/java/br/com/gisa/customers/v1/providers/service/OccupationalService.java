package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.commons.filter.PageRequestBuilder;
import br.com.gisa.customers.v1.commons.filter.SpecificationsBuilder;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalRequest;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalResponse;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.IOccupationalRepository;
import br.com.gisa.customers.v1.providers.specifications.OccupationalSpecification;
import br.com.gisa.customers.v1.providers.specifications.ProviderSpecification;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OccupationalService {

    private IOccupationalRepository occupationalRepository;

    @Autowired
    private SpecificationsBuilder<Occupational> builder;

    public Page<GetOccupationalResponse> findAll(GetOccupationalRequest request){

        var params = new ObjectMapper()
                .convertValue(request, new TypeReference<Map<String, Object>>() {});

        var spec = builder.with(params).build();
        var page = PageRequestBuilder.getPageRequest(request.getLimit(), request.getOffset(), request.getSortBy());

        Page<Occupational> list =  occupationalRepository.findAll(spec,page);

        return null; //list.map(this::convertToDto);
    }

}
