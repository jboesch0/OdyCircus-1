package models;
import java.util.Date;

public class Event {
	
	
	private int id;
	private City city;
	/*
	 * Ajouter les dates
	 */
	// format date : YYYY-MM-DD
	// format datetime / timestamp : YYYY-MM-DD hh:mm:ss
	private String description;
	private Circus circus;
	
	
	public Event(int id, String description, Circus circus){
		this.id = id;
		this.description = description;
		this.circus = circus;
		
	}
	
	
	//Getters
	public int getId(){
		return id;
	}
	
	public City getCity(){
		return city;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Circus getCircus(){
		return circus;
	}
	
	//Setters
	public void setCity(City city){
		this.city = city;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setCircus(Circus circus){
		this.circus = circus;
	}
	

}
