package com.example.models;
//TODO: Gestion des dates
import java.util.Calendar;

public class Picture {

	//Attributes
	private int id;
	private Event event;
	private String description;
    private String location;
	private User user;
	private boolean valid;
	private Calendar date;


    //Constructors
	public Picture(){
        this.event=null;
        this.description="";
        this.user=null;
        this.date=null;
    }
	
	public Picture(int id, Event event, String description, User user, boolean valid,Calendar date){
		this.id = id;
		this.event = event;
		this.description = description;
		this.user = user;
		this.valid = valid;
        this.date = date;
    }

	//Methodes
    //public static Picture addPicture(){

    //}

    //public static Picture getPicture(){

    //}

	//Getters
	public int getId(){
		return id;
	}
	
	public Event getEvent(){
		return event;
	}
	
	public String getDescription(){
		return description;
	}
	
	public User getUser(){
		return user;
	}
	
	public boolean getValid(){
		return valid;
	}
	
	//Setters
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setValid(boolean valid){
		this.valid = valid;
	}
	
	public void setEvent(Event event){
		this.event = event;
	}

}
