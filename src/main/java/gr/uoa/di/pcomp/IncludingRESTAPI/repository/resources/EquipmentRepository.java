package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Equipment;

@Repository
@Transactional
public interface EquipmentRepository extends ResourceBaseRepository<Equipment>{

}
