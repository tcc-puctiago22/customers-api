package br.com.gisa.customers.v1.associates.repository;

import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IAssociateRepository extends  JpaRepository<Associate, Long>, JpaSpecificationExecutor<Associate> {

        @Override
        Page<Associate> findAll(Specification<Associate> specification, Pageable pageable);
        Optional<Associate> findByUuid(String uuid);


    }