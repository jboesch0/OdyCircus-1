package models;

public class Message {
	
	private int id;
	private User fromUser;
	private User toUser;
	private String text;
	//date
	
	public Message(int id, User fromUser, User toUser, String text){
		this.id = id;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.text = text;
	}
	
	//Getters
	public int getId(){
		return id;
	}
	
	public User getFromUser(){
		return fromUser;
	}
	
	public User getToUser(){
		return toUser;
	}
	
	public String getText(){
		return text;
	}
	
	//Setters
	public void setFromUser(User fromUser){
		this.fromUser = fromUser;
	}
	
	public void setToUser(User toUser){
		this.toUser = toUser;
	}
	
	public void setText(String text){
		this.text = text;
	}

}
