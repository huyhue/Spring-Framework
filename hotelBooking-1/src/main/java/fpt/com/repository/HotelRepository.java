package fpt.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.com.pojo.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long>{
	List<Hotel> findByHotelNameLikeOrderByHotelName(String hotelName);
}
