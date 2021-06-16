package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Operator;
@Repository
@Transactional
public interface OperatorRepository extends ResourceBaseRepository<Operator>{

}
