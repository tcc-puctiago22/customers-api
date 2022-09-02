package br.com.gisa.customers.v1.providers.repository;

import br.com.gisa.customers.v1.partners.model.Partner;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IProvidersRepository extends JpaRepository<Provider, Long>, JpaSpecificationExecutor<Provider> {

    @Override
    Page<Provider> findAll(Specification<Provider> specification, Pageable pageable);

    Optional<Provider> findByUuid(String uuid);


}
