package fpt.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.com.pojo.Hotel;
import fpt.com.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel save(Hotel entity) {
		return hotelRepository.save(entity);
	}

	@Override
	public List<Hotel> saveAll(List<Hotel> entities) {
		return (List<Hotel>) hotelRepository.saveAll(entities);
	}

	@Override
	public Optional<Hotel> findById(Long id) {
		return hotelRepository.findById(id);
	}

	public List<Hotel> findByHotelNameLikeOrderByHotelName(String name) {
		return hotelRepository.findByHotelNameLikeOrderByHotelName("%"+name+"%");
	}

	@Override
	public boolean existsById(Long id) {
		return hotelRepository.existsById(id);
	}

	@Override
	public Iterable<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Hotel> findAllById(List<Long> ids) {
		return (List<Hotel>) hotelRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return hotelRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public void delete(Hotel entity) {
		hotelRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Hotel> entities) {
		hotelRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hotelRepository.deleteAll();
	}

	
}
