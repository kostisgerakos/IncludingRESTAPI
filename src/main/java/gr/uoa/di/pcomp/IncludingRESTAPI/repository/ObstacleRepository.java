package gr.uoa.di.pcomp.IncludingRESTAPI.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Obstacle;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle, Integer>{ 
}
