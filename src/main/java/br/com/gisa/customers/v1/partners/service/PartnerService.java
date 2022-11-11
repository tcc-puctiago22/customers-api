package br.com.gisa.customers.v1.partners.service;

import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.commons.exceptions.ExceptionCodes;
import br.com.gisa.customers.v1.commons.exceptions.ResponseCodeException;
import br.com.gisa.customers.v1.commons.helper.Helper;
import br.com.gisa.customers.v1.partners.dto.GetPartnerRequest;
import br.com.gisa.customers.v1.partners.dto.GetPartnerResponse;
import br.com.gisa.customers.v1.partners.dto.post.PartnerDTO;
import br.com.gisa.customers.v1.partners.dto.post.PostPartnerDTO;
import br.com.gisa.customers.v1.partners.dto.put.PuTProviderDTO;
import br.com.gisa.customers.v1.partners.dto.put.PutPatnerDTO;
import br.com.gisa.customers.v1.partners.model.Partner;
import br.com.gisa.customers.v1.partners.repository.IPartnerRepository;
import br.com.gisa.customers.v1.partners.specifications.PartnerSpecification;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderResponse;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.repository.IProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class PartnerService {

    @Autowired
    private Helper helper;

    @Autowired
    private IPartnerRepository iPartnerRepository;
    @Autowired
    private IProvidersRepository iProvidersRepository;

    @Autowired
    private PartnerSpecification partnerSpecification;

    public Page<GetPartnerResponse> findAll(GetPartnerRequest request){
        Specification<Partner> specification =  partnerSpecification.hasUf(request.getCity());

        Page<Partner> list =  iPartnerRepository.findAll(specification,request.getPageable());

        return list.map(this::convertToDto);
    }
    private GetPartnerResponse convertToDto(Partner request) {
        return helper.convertToDtoGetPartnerResponse(request);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public PartnerDTO post(PostPartnerDTO request) {

        Partner partner = helper.converterDTOtoPartner(request);
        partner.getCustomer().setPartner(null);
        iPartnerRepository.saveAndFlush(partner);
        return  helper.converterPartnerToDTO(partner);
    }


    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public PartnerDTO putPartner(PutPatnerDTO request) {

        Partner partner = helper.converterDTOtoPartnerPut(request);
        iPartnerRepository.saveAndFlush(partner);

        return  helper.converterPartnerToDTO(partner);
    }

    public PartnerDTO putPartnerProviders(PutPatnerDTO request) {

        Partner partner = iPartnerRepository.findByUuid(request.getUuid())
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.PARTNER_NOT_FOUND));

        Set<Provider> listProviders = new HashSet<>();

        for(PuTProviderDTO puTProviderDTO : request.getListProviders()){

            Provider providerFind = iProvidersRepository.findByUuid(puTProviderDTO.getUuid()).
                    orElseThrow(() -> new ResponseCodeException(ExceptionCodes.PARTNER_NOT_FOUND));

            listProviders.add(providerFind);
        }

        partner.setListProviders(listProviders);
        partner.getCustomer().setPartner(null);
        iPartnerRepository.saveAndFlush(partner);

        return helper.converterPartnerToDTO(partner);
    }

    public PartnerDTO findByUuid(String uuid) {
        Partner entity = iPartnerRepository.
                findByUuid(uuid)
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.PARTNER_NOT_FOUND));
        return helper.converterPartnerToDTO(entity);
    }
}
