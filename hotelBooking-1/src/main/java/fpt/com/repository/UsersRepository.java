package fpt.com.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.com.pojo.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{
	
	@Query("from Users where userEmail = :userEmail and password = :password and type = :type")
	Users loginUser(
			@Param("userEmail") String userEmail,
			@Param("password") String password,
			@Param("type") String type);
}
