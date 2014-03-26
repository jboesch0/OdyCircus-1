package com.example.models;

import com.example.jsonparserapi.*;
import java.io.IOException;

public class Circus {

	//Attributes
	private int id;
	private String name;
	private Country country;
	private String description;
	private String picture;
	private boolean genuine;

    //Constuctors
    public Circus(){
        this.name = "";
        this.country = null;
        this.description = "";
        this.picture = "";
    }
	
	public Circus(int id, String name, Country country, String description, String picture, boolean genuine){
		this.id = id;
		this.name = name;
		this.country = country;
		this.description = description;
		this.picture = picture;
		this.genuine = genuine;
	}
	
	//Methodes
	public static Circus addCircus(String name, int country, String description) throws IOException {
        Circus circus = new Circus();
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/add_circus.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&name=" +
                name +
                "&country=" +
                country +
                "&description=" +
                description;

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
        }
        else{
            circus.setId(jsonObject.getInt("id"));
            circus.setName(name);
            circus.setDescription(description);
            circus.setCountry(Country.getCountry(jsonObject.getInt("country")));
            System.out.println("Successfull !!");
        }
	       return circus;
    }

    public static void updateCircus(int id, String name, int country, String description, String picture, boolean genuine ) throws IOException {
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/update_user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&" +
                "id=" +
                id+
                "&country=" +
                country +
                "&description=" +
                description +
                "&name=" +
                name +
                "&picture=" +
                picture +
                "&genuine=" +
                genuine;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
        }
        else{
            System.out.println("Successfull");
        }
    }
	
	public static void deleteCircus(int id) throws IOException {
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/delete_user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
        }
        else{
            System.out.println("Successfull");
        }
	}

    public static Circus getCircus(int id) throws IOException {
        Circus circus = new Circus();
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
        }
        else{
            circus.setId(jsonObject.getInt("id"));
            circus.setName(jsonObject.getString("name"));
            circus.setCountry(Country.getCountry(jsonObject.getInt("country")));
            circus.setDescription(jsonObject.getString("description"));
            circus.setGenuine(jsonObject.getBoolean("genuine"));
            circus.setPicture(jsonObject.getString("picture"));
        }
        return circus;
    }
	
	//Getters
    public Country getCountry() {
        return country;
    }

    public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}
	
	public String getPicture(){
		return picture;
	}
	
	public boolean getGenuine(){
		return genuine;
	}
	
	//Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
		this.name = name;
	}

	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPicture(String picture){
		this.picture = picture;
	}
	
	public void setGenuine(boolean genuine){
		this.genuine = genuine;
	}

    public void setCountry(Country country) {
        this.country = country;
    }
}
