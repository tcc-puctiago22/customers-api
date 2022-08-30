package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderRequest;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.IProvidersRepository;
import br.com.gisa.customers.v1.providers.specifications.ProviderSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProvidersService {

    private IProvidersRepository providersRepository;
    private  ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProviderSpecification providerSpecification;

    public Page<GetProviderResponse> findAll(GetProviderRequest request){

        Page<Provider> list =  providersRepository.findAll(providerSpecification.getFilter(request),request.getPageable());

        return list.map(this::convertToDto);
    }

    private GetProviderResponse convertToDto(Provider request) {
        GetProviderResponse dto = modelMapper.map(request, GetProviderResponse.class);
        return dto;
    }

    public ProviderDTO post(PostProviderDTO request) {
        return null;
    }
}
