package fpt.com.services;

import java.util.List;
import java.util.Optional;

import fpt.com.pojo.Booking;

public interface BookingService {

	List<Booking> findByCurUser(String curUser);
	
	void deleteAll();

	void deleteAll(List<Booking> entities);

	void delete(Booking entity);

	void deleteById(Long id);

	long count();

	Iterable<Booking> findAll();

	boolean existsById(Long id);

	Optional<Booking> findById(Long id);

	List<Booking> saveAll(List<Booking> entities);

	Booking save(Booking entity);

}
