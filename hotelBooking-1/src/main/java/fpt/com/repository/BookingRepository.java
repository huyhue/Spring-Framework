package fpt.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.com.pojo.Booking;
import fpt.com.pojo.Hotel;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
	List<Booking> findByCurUser(String curUser);
}
