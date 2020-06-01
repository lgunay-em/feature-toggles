package com.example.demo.repository;

import com.example.demo.models.FeatureToggle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "features", path = "features")
public interface FeatureToggleRepository extends PagingAndSortingRepository<FeatureToggle, Long> {

    Optional<FeatureToggle> findByTechnicalName(@Param("technicalName") String name);

}
