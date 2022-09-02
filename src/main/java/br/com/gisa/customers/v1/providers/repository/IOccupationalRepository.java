package br.com.gisa.customers.v1.providers.repository;

import br.com.gisa.customers.v1.providers.model.Occupational;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IOccupationalRepository extends JpaRepository<Occupational, Long>, JpaSpecificationExecutor<Occupational> {

    @Override
    Page<Occupational> findAll(Specification<Occupational> specification, Pageable pageable);

    Optional<Occupational> findByuuid(String uuid);

}
