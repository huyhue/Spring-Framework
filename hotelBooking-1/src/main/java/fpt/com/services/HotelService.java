package fpt.com.services;

import java.util.List;
import java.util.Optional;

import fpt.com.pojo.Hotel;

public interface HotelService {

	List<Hotel> findByHotelNameLikeOrderByHotelName(String name);
	
	void deleteAll();

	void deleteAll(List<Hotel> entities);

	void delete(Hotel entity);

	void deleteById(Long id);

	long count();

	List<Hotel> findAllById(List<Long> ids);

	Iterable<Hotel> findAll();

	boolean existsById(Long id);

	Optional<Hotel> findById(Long id);

	List<Hotel> saveAll(List<Hotel> entities);

	Hotel save(Hotel entity);

}
