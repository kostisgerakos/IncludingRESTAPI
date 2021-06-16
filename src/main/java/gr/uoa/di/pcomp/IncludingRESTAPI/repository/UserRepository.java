package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UserProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<UserProjection> findAllProjectedBy();
	User getUserByUsername(String userName);
	UserProjection getUserProjectedByUsername(String userName);
	Optional<UserProjection> findProjectionByUserId(Integer userId);
}
