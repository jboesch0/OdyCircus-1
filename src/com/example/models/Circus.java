package models;

public class Circus {

	
	private int id;
	private String name;
	private Country country;
	private String description;
	private boolean picture;
	private boolean genuine;
	
	
	public Circus(int id, String name, Country country, String description, boolean picture, boolean genuine){
		this.id = id;
		this.name = name;
		this.country = country;
		this.description = description;
		this.picture = picture;
		this.genuine = genuine;
	}
	
	//Mehodes
	public void addCircus(){
		
	}
	
	public void deleteCircus(){
		
	}	
	
	//Getters
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	
	public String getDescription(){
		return description;
	}
	
	public boolean getPicture(){
		return picture;
	}
	
	public boolean getGenuine(){
		return genuine;
	}
	
	//Setters
	public void setName(String name){
		this.name = name;
	}
	
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPicture(boolean picture){
		this.picture = picture;
	}
	
	public void setGenuine(boolean genuine){
		this.genuine = genuine;
	}	
	
}
