package models;

import java.util.Date;

public class Picture {
	
	private int id;
	private Event event;
	private String description;
	private User user;
	private boolean valid;
	private Date date;
	
	
	public Picture(int id, Event event, String description, User user, boolean valid/*Date date*/){
		this.id = id;
		this.event = event;
		this.description = description;
		this.user = user;
		this.valid = valid;
        //this.date = date;
    }
	
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
