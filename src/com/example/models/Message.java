package com.example.models;
//TODO: Gestion de la date

import com.example.jsonparserapi.*;
import java.io.IOException;
import java.util.Calendar;

public class Message {

    //Attributes
	private int id;
	private User fromUser;
	private User toUser;
	private String text;
	private Calendar date;

    //Constructors
    public Message(){
        this.fromUser = null;
        this.toUser = null;
        this.text = "";
        this.date = null;
    }
	
	public Message(int id, User fromUser, User toUser, String text/*, Calendar date*/){
		this.id = id;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.text = text;
        //this.date = date;
	}

    //Methodes
    public static Message getMessage(int id) throws IOException, JSONException {
        Message message;
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/message.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
            message = null;
        }
        else{
            message = new Message(jsonObject.getInt("id"),
                    User.getUser(jsonObject.getInt("fromUser")),
                    User.getUser(jsonObject.getInt("toUser")),
                    jsonObject.getString("text"))//,
                    /*jsonObject.getInt("")*/;
        }
        return message;
    }

    public static Message addMessage(User fromUser, User toUser, String text, Calendar date) throws IOException {
        Message message ;
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/add_user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&fromUser=" +
                fromUser +
                "&toUser=" +
                toUser +
                "&text=" +
                text +
                "&date="; /*+
                date.toSql();*/

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
            message = null;
        }
        else{
            message = new Message();
            message.setId(jsonObject.getInt("id"));
            message.setFromUser(fromUser);
            message.setToUser(toUser);
            message.setText(text);
            //message.setDate():
            System.out.println("Successfull !!");
        }
        return message;
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

    public void setId(int id) {
        this.id = id;
    }
}
