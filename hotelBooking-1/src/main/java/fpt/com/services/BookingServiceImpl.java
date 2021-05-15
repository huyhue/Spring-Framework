package fpt.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.com.pojo.Booking;
import fpt.com.repository.BookingRepository;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking save(Booking entity) {
		return bookingRepository.save(entity);
	}

	@Override
	public List<Booking> saveAll(List<Booking> entities) {
		return (List<Booking>) bookingRepository.saveAll(entities);
	}

	public List<Booking> findByCurUser(String curUser) {
		return bookingRepository.findByCurUser(curUser);
	}

	@Override
	public Optional<Booking> findById(Long id) {
		return bookingRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return bookingRepository.existsById(id);
	}

	@Override
	public Iterable<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public long count() {
		return bookingRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		bookingRepository.deleteById(id);
	}

	@Override
	public void delete(Booking entity) {
		bookingRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Booking> entities) {
		bookingRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookingRepository.deleteAll();
	}
	
	
}
