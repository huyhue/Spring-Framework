package fpt.com.services;

import java.util.List;
import java.util.Optional;

import fpt.com.pojo.Users;

public interface UsersService {

	void deleteAll();

	void deleteAll(List<Users> entities);

	void delete(Users entity);

	void deleteById(Long id);

	long count();

	List<Users> findAllById(List<Long> ids);

	Iterable<Users> findAll();

	boolean existsById(Long id);

	Optional<Users> findById(Long id);

	List<Users> saveAll(List<Users> entities);

	Users save(Users entity);

	Users loginUser(String userEmail, String password, String type);
	
}
