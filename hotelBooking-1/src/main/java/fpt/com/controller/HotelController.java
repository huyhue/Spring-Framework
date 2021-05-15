package fpt.com.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fpt.com.pojo.Booking;
import fpt.com.pojo.Hotel;
import fpt.com.pojo.Users;
import fpt.com.services.BookingService;
import fpt.com.services.HotelService;

@Controller
public class HotelController {
	@Autowired
	public HotelService hotelService;
	
	@Autowired
	public BookingService bookingService;
	
	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public ModelAndView displayHotels(HttpServletRequest request) {
		List<Hotel> hotels = (List<Hotel>) hotelService.findAll();
		return new ModelAndView("hotels", "hotels", hotels);
	}

	@RequestMapping(value = "/hoteladd", method = RequestMethod.GET)
	public String getAddHotelPage() {
		return "hoteladd";
	}

	@RequestMapping(value = "/hotelbook/*", method = RequestMethod.GET)
	public ModelAndView getBookView(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		Optional<Hotel> hotel = hotelService.findById(Long.parseLong(sId));
		return new ModelAndView("hotelbook", "hotel", hotel.get());
	}

	@RequestMapping(value = "/hoteldelete/*", method = RequestMethod.GET)
	public String deleteHotel(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		hotelService.deleteById(Long.parseLong(sId));
		return "redirect:/hotels";
	}

	@RequestMapping(value = "/hotelupdate/*", method = RequestMethod.GET)
	public ModelAndView updateHotelView(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		Optional<Hotel> hotel = hotelService.findById(Long.parseLong(sId));
		return new ModelAndView("hotelupdate", "hotel", hotel.get());
	}

	@RequestMapping(value = "/hotelupdate/*", method = RequestMethod.POST)
	public String updateHotel(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		System.out.println(id + " from hotel update post request");
		String hotelName = request.getParameter("hotelName");
		String location = request.getParameter("location");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		Hotel h = new Hotel(Long.parseLong(sId), hotelName, location, image, price, description);
		hotelService.save(h);
		return "redirect:/hotels";
	}

	@RequestMapping(value = "/hotelbook", method = RequestMethod.POST)
	public String bookHotel(HttpServletRequest request) throws Exception {

		// GET CURRENT USER
		HttpSession session = request.getSession();
		Users curUser = (Users) session.getAttribute("curUser");

		// GET OTHER ORDER ATTRIBUTE FROM FORM
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String date = request.getParameter("date");
		String hotelName = request.getParameter("hotelName");
		String phone = request.getParameter("phone");

		// create new order object and store in database
		Booking booking = new Booking();
		booking.setFirstName(firstName);
		booking.setLastName(lastName);
		booking.setHotelName(hotelName);
		booking.setPhone(phone);
		booking.setDate(date);
		booking.setCurUser(curUser.getUserEmail());
		try {
			Booking o = bookingService.save(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/hotels";
	}

	@RequestMapping(value = "/hoteldetail/*", method = RequestMethod.GET)
	public ModelAndView getHotelDetail(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		System.out.println("ID detail: "+Long.parseLong(sId));
		Optional<Hotel> hotel = hotelService.findById(Long.parseLong(sId));
		return new ModelAndView("hoteldetail", "hotel", hotel.get());
	}

	@RequestMapping(value = "/hoteladd", method = RequestMethod.POST)
	public String addHotel(HttpServletRequest request) throws IllegalStateException {
		String hotelName = request.getParameter("hotelName");
		String location = request.getParameter("location");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setImage(image);
		hotel.setLocation(location);
		hotel.setPrice(price);
		hotel.setDescription(description);
		try {
			Hotel h = hotelService.save(hotel);
			return "redirect:/hotels";
		} catch (Exception e) {}
		return null;
	}

	@RequestMapping(value = "/viewbooking", method = RequestMethod.GET)
	public ModelAndView viewBooking(HttpServletRequest request) throws Exception {
		// GET CURRENT USER
		HttpSession session = request.getSession();
		Users curUser = (Users) session.getAttribute("curUser");

		// GET ALL BOOKING UNDER THIS USER
//		List<Booking> bookings = (List<Booking>) bookingService.findAll();
		List<Booking> bookings = (List<Booking>) bookingService.findByCurUser(curUser.getUserEmail());
		return new ModelAndView("viewbooking", "bookings", bookings);
	}
	
	@RequestMapping(value = "/managebooking", method = RequestMethod.GET)
	public ModelAndView manangeBookingView(HttpServletRequest request) throws Exception {
		List<Booking> bookings = (List<Booking>) bookingService.findAll();
		for(Booking booking : bookings) {
			System.out.println(booking.getHotelName());
		}
		return new ModelAndView("managebooking", "bookings", bookings);
	}
	
	@RequestMapping(value = "/cancelbooking/*", method = RequestMethod.GET)
	public String deleteBooking(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		String sId = id.replaceAll("'", "");
		System.out.println(sId);
		bookingService.deleteById(Long.parseLong(sId));
		return "redirect:/viewbooking";
	}

	@RequestMapping(value = "/hotelsearch", method = RequestMethod.POST)
	public ModelAndView searchHotel( HttpServletRequest request) throws Exception {
		String searchName = request.getParameter("searchName");
		List<Hotel> hotels = hotelService.findByHotelNameLikeOrderByHotelName(searchName);
		return new ModelAndView("hotels", "hotels", hotels);
	}
}
