package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ResourceProjection;

@NoRepositoryBean
public interface ResourceBaseRepository<T extends Resource>  extends JpaRepository<T, Long> {
    public T findByResourceId(Integer id);
    public ResourceProjection findProjectedByResourceId(Integer id);
    List<ResourceProjection> findAllProjectedBy();
    List<ResourceProjection> findAllByTestbedAreaTestbedAreaId(Integer testbedAreaId);
	List<ResourceProjection> findAllByTestbedAreaTestbedTestbedId(Integer testbedId);
    //Optional<T> findResourceByResourceName(String resourceName);
    Optional<ResourceProjection> findResourceByResourceName(String resourceName);

}
