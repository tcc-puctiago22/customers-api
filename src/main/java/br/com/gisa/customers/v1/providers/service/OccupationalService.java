package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalRequest;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalResponse;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.IOccupationalRepository;
import br.com.gisa.customers.v1.providers.specifications.OccupationalSpecification;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OccupationalService {

    @Autowired
    private IOccupationalRepository occupationalRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<GetOccupationalResponse> findAll(GetOccupationalRequest request){

        Specification<Occupational> specification = new OccupationalSpecification(request);

        Page<Occupational> list =  occupationalRepository.findAll(specification,request.getPageable());

        return list.map(this::convertToDto);
    }

    private GetOccupationalResponse convertToDto(Occupational request) {
        return modelMapper.map(request, GetOccupationalResponse.class);
    }
}
