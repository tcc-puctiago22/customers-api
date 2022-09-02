package br.com.gisa.customers.v1.associates.service;

import br.com.gisa.customers.v1.associates.dto.post.AssociateDTO;
import br.com.gisa.customers.v1.associates.dto.post.PostAssociateDTO;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.associates.repository.IAssociateRepository;
import br.com.gisa.customers.v1.commons.helper.Helper;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.dto.post.PostProviderDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
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

}
