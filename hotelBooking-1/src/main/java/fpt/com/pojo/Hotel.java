package fpt.com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique= true, nullable = false)
	private long id;
	
	@Column(name= "hotelName")
	private String hotelName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="image")
	private String image;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	public Hotel(long id, String hotelName, String location, String image, String price, String description) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.image = image;
		this.price = price;
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="price")
	private String price;
	
	@Column(name="description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
