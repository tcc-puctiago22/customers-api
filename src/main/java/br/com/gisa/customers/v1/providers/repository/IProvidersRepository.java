package br.com.gisa.customers.v1.providers.repository;

import br.com.gisa.customers.v1.providers.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProvidersRepository extends JpaRepository<Provider, Long>, JpaSpecificationExecutor<Provider> {

    @Override
    Page<Provider> findAll(Specification<Provider> specification, Pageable pageable);

}
