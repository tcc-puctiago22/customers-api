package br.com.gisa.customers.v1.providers.service;

import br.com.gisa.customers.v1.commons.helper.Helper;
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
import br.com.gisa.customers.v1.providers.specifications.ProviderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

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
        Specification<Provider> specification =  providerSpecification.hasOccupationDescrition(request.getOccupationDescription());

        Page<Provider> list =  providersRepository.findAll(specification,request.getPageable());

        return list.map(this::convertToDto);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public ProviderDTO post(PostProviderDTO request) {

        Provider provider = helper.converterDTOtoProvider(request);
        Set<Occupational> listOccupational = new HashSet<>();

        for(String occu: request.getListOccupational()){
            Occupational occupational = getOccupational(occu);
            listOccupational.add(occupational);
        }
        provider.setListOccupational(listOccupational);
        providersRepository.saveAndFlush(provider);

        return converterProviderToDTO(provider);
    }

    private Occupational getOccupational(String uuid) {

        return  iOccupationalRepository.
                findByUuid(uuid)
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.OCCUPATION_NOT_FOUND));
    }



    private GetProviderResponse convertToDto(Provider request) {
        return helper.convertToDto(request);
    }

    private ProviderDTO converterProviderToDTO(Provider request){
        return helper.converterProviderToDTO(request);
    }

    public ProviderDTO findByUuid(String uuid) {
       Provider provider = providersRepository.
                 findByUuid(uuid)
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.PROVIDER_NOT_FOUND));
       return converterProviderToDTO(provider);
    }
}
