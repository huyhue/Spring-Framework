package fpt.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.com.pojo.Users;
import fpt.com.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;

	@Override
	public Users save(Users entity) {
		return usersRepository.save(entity);
	}

	@Override
	public Users loginUser(String userEmail, String password, String type) {
		return usersRepository.loginUser(userEmail, password, type);
	}
	

	@Override
	public List<Users> saveAll(List<Users> entities) {
		return (List<Users>) usersRepository.saveAll(entities);
	}

	@Override
	public Optional<Users> findById(Long id) {
		return usersRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return usersRepository.existsById(id);
	}

	@Override
	public Iterable<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public List<Users> findAllById(List<Long> ids) {
		return (List<Users>) usersRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return usersRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		usersRepository.deleteById(id);
	}

	@Override
	public void delete(Users entity) {
		usersRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Users> entities) {
		usersRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		usersRepository.deleteAll();
	}

}
