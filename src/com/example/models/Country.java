package models;

public class Country {

	private int id;
	private String name;
	private String short_name;
	private float latitude;
	private float longitude;
	
	public Country(int id, String name, String short_name, float latitude, float longitude){
		this.id = id;
		this.name = name;
		this.short_name = short_name;
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
	
	public String getShortName(){
		return short_name;
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
	
	public void setShortName(String short_name){
		this.short_name = short_name;
	}
	
	public void setLatitude(float latitude){
		this.latitude = latitude;
	}
	
	public void setLongitude(float longitude){
		this.longitude = longitude;
	}
	
}
