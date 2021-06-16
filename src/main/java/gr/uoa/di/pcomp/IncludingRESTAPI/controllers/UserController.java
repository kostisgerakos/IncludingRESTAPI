package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.MappingNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UserProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.UserRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@RestController
class UserController {
	/*
	 * @Autowired private IUserService userService;
	 */

	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/users")
	List<UserProjection> allUsers() {
		return repository.findAllProjectedBy();
	}

	@GetMapping("/usernames")
	@JsonView(value = { View.UserView.Username.class})
	List<UserProjection> allUsernames() {
		return repository.findAllProjectedBy();
	}
	
	@GetMapping("/userByUsername/{username}")
	UserProjection getByUsername(@PathVariable String username) {
		return repository.getUserProjectedByUsername(username);
	}

	/*@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}*/

	// Single item

	@GetMapping("/users/{id}")
	Optional<UserProjection> one(@PathVariable Integer id) {

		return repository.findProjectionByUserId(id)
		// .orElseThrow(() -> new
		// UserNotFoundException(id))
		;
	}

	/*
	 * @PutMapping("/users/{id}") User replaceUser(@RequestBody User
	 * newUser, @PathVariable Integer id) {
	 * 
	 * return repository.findById(id) .map(user -> {
	 * user.setContent(newUser.getContent());
	 * user.setUserDescription(newUser.getUserDescription()); return
	 * repository.save(user); }) .orElseGet(() -> { newUser.setUserId(id); return
	 * repository.save(newUser); }); }
	 */

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}