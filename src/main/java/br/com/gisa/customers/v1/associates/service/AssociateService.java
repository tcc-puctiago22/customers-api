package br.com.gisa.customers.v1.associates.service;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.get.GetAssociateResponse;
import br.com.gisa.customers.v1.associates.dto.post.get.GetAssocieateRequest;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.associates.repository.IAssociateRepository;
import br.com.gisa.customers.v1.associates.specifications.AssocieateSpecification;
import br.com.gisa.customers.v1.commons.exceptions.ExceptionCodes;
import br.com.gisa.customers.v1.commons.exceptions.ResponseCodeException;
import br.com.gisa.customers.v1.commons.helper.Helper;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalResponse;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import br.com.gisa.customers.v1.providers.specifications.OccupationalSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AssociateService {

    @Autowired
    private IAssociateRepository iAssociateRepository;

    @Autowired
    private Helper helper;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public AssociateDTO postAssociate(PostAssociateDTO request) {

        Associate entity = helper.converterDTOtoAssociate(request);
        iAssociateRepository.save(entity);
        return helper.converterAssociateToDTO(entity);
    }

    public AssociateDTO findByUuid(String uuid) {
        Associate entity = iAssociateRepository.
                findByUuid(uuid)
                .orElseThrow(() -> new ResponseCodeException(ExceptionCodes.PROVIDER_NOT_FOUND));
        return helper.converterAssociateToDTO(entity);
    }

    public Page<GetAssociateResponse> findAll(GetAssocieateRequest request) {


        Specification<Associate> specification = new AssocieateSpecification(request);

        Page<Associate> list =  iAssociateRepository.findAll(specification,request.getPageable());

        return list.map(this::convertToDto);
    }

    private GetAssociateResponse convertToDto(Associate request) {

        return  helper.converterGetAssociatelResponse(request);
        //return modelMapper.map(request, GetOccupationalResponse.class);
    }
}
