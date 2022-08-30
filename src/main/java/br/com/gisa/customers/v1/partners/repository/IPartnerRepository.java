package br.com.gisa.customers.v1.partners.repository;

import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.partners.model.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPartnerRepository  extends JpaRepository<Partner, Long>, JpaSpecificationExecutor<Partner> {

    @Override
    Page<Partner> findAll(Specification<Partner> specification, Pageable pageable);

}