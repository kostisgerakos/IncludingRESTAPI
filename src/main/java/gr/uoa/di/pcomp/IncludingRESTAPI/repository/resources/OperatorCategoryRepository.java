package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.OperatorCategory;

@Repository
public interface OperatorCategoryRepository extends JpaRepository<OperatorCategory, Integer>{

}
