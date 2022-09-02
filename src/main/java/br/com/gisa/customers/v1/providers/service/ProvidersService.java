package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.commons.Helper;
import br.com.gisa.customers.v1.commons.exceptions.ExceptionCodes;
import br.com.gisa.customers.v1.commons.exceptions.ResponseCodeException;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderRequest;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.IOccupationalRepository;
import br.com.gisa.customers.v1.providers.repository.IProvidersRepository;
import br.com.gisa.customers.v1.providers.specifications.OccupationalSpecification;
import br.com.gisa.customers.v1.providers.specifications.ProviderSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ProvidersService {

    @Autowired
    private IProvidersRepository providersRepository;
    @Autowired
    private IOccupationalRepository iOccupationalRepository;
    @Autowired
    private Helper helper;

    @Autowired
    private ProviderSpecification providerSpecification;

    public Page<GetProviderResponse> findAll(GetProviderRequest request){

        Page<Provider> list =  providersRepository.findAll(providerSpecification.getFilter(request),request.getPageable());

        return list.map(this::convertToDto);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public ProviderDTO postProvider(PostProviderDTO request) {

        Occupational occupational= getOccupational(request.getUuidOccupational());
        Provider provider = converterDTOtoProvider(request);
        provider.setOccupational(occupational);
        provider.getCustomer().setProvider(null);
        provider.setRegistration(helper.getProvideregistration());
        providersRepository.save(provider);

        return converterProviderToDTO(provider);
    }

    private Occupational getOccupational(String uuid) {

        return  iOccupationalRepository.
                findByuuid(uuid)
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.OCCUPATION_NOT_FOUND));
    }



    private GetProviderResponse convertToDto(Provider request) {
        return helper.convertToDto(request);
    }

    private Provider converterDTOtoProvider(PostProviderDTO request){
       return helper.converterDTOtoProvider(request);
    }
    private ProviderDTO converterProviderToDTO(Provider request){
        return helper.converterProviderToDTO(request);
    }
}
