package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ResourceProjection;

@Repository
@Transactional
public interface ResourceRepository extends ResourceBaseRepository<Resource>{//JpaRepository<Resource, Integer> {
    //Resource getByResourceId(Integer resourceId);
    List<ResourceProjection> findByResourceName(String resourceName);
    //Optional<Resource> findResourceByResourceName(String resourceName);


}
