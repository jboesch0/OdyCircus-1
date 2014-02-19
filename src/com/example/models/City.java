package models;

public class City {
	
	
	private int id;
	private String name;
	private Country country;
	private float latitude;
	private float longitude;
	
	
	public City(int id, String name, Country country, float latitude, float longitude){
		this.id = id;
		this.name = name;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	//Getters
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Country getCountry(){
		return country;
	}
	
	public float getLatitude(){
		return latitude;
	}
	
	public float getLongitude(){
		return longitude;
	}
	
	//Setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setCountry(Country country){
		this.country = country;
	}
	
	public void setLatitude(float latitude){
		this.latitude = latitude;
	}
	
	public void setLongitude(float longitude){
		this.longitude = longitude;
	}
}
