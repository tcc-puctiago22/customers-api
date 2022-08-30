package br.com.gisa.customers.v1.associates.service;

import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.associates.repository.IAssociateRepository;
import br.com.gisa.customers.v1.commons.filter.SpecificationsBuilder;
import br.com.gisa.customers.v1.providers.model.Occupational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociateService {

    private IAssociateRepository iAssociateRepository;

    @Autowired
    private SpecificationsBuilder<Associate> builder;
}
