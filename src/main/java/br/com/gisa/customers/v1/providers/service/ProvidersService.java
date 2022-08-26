package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.ProviderRequest;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.ProvidersRepository;
import br.com.gisa.customers.v1.providers.specifications.ProviderSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvidersService {

    private ProvidersRepository providersRepository;
    private  ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProviderSpecification providerSpecification;

    public Page<ProviderDTO> findAll(ProviderRequest request){

        Page<Provider> list =  providersRepository.findAll(providerSpecification.getFilter(request),request.getPageable());

        return list.map(this::convertToDto);
    }

    private ProviderDTO convertToDto(Provider request) {
        ProviderDTO dto = modelMapper.map(request, ProviderDTO.class);
        return dto;
    }
}
