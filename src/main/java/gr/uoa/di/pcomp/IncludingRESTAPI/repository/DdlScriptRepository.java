package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;


@Repository
public interface DdlScriptRepository extends JpaRepository<DdlScript, Integer>{

}
