package model;

public class Task {

	protected int id;
	protected String date;
	
	protected String name, email, address, phone, city, country, education;
	
	protected String photo;
	
	protected byte[] image;
	
	public Task(int id, String name, String email, String address, String phone, String city, String country, String education, String photo, byte[] image){
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.city=city;
		this.country=country;
		this.education=education;
		this.photo=photo;
		this.image=image;
	}
	
	public Task(int id, String name, String email, String address, String phone, String city, String country, String education){
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.city=city;
		this.country=country;
		this.education=education;
		
	}
	
	public Task(int id, String name, String email, String address, String phone, String city, String country, String education, String photo){
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.city=city;
		this.country=country;
		this.education=education;
		this.photo=photo;
	}
	
	public Task(String name, String email, String address, String phone, String city, String country, String education, String photo){
		super();
		
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.city=city;
		this.country=country;
		this.education=education;
		this.photo=photo;
	}
	
	public Task(int id, String date, String name, String city) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.city = city;
	}
	
	public Task(int id, String name, String email, String address, String phone, String city, String country, String education, byte[] image){
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.city=city;
		this.country=country;
		this.education=education;
		this.image=image;
	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id=id;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date=date;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email=email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address=address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone=phone;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city=city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country=country;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education=education;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo=photo;
		}
	
		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}
	}
	
	
	

