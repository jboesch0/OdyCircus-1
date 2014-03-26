package com.example.models;


import com.example.jsonparserapi.*;
import java.io.IOException;

public class Country {

    //Attributes
	private int id;
	private String name;
	private String short_name;
	private float latitude;
	private float longitude;

    //Constuctors
    public Country(){
        this.name = name;
        this.short_name = short_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
	
	public Country(int id, String name, String short_name, float latitude, float longitude){
		this.id = id;
		this.name = name;
		this.short_name = short_name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	//Methodes
    public static Country getCountry(int id) throws IOException {
        Country country = new Country();
        String address = "http://ns303921.ovh.net/~odycircu/api/location/country.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
        }
        else{
            country.setId(jsonObject.getInt("id"));
            country.setName(jsonObject.getString("name"));
            country.setShortName(jsonObject.getString("shortName"));
            country.setLatitude((float) jsonObject.getDouble("latitude"));
            country.setLongitude((float) jsonObject.getDouble("longitude"));
        }
        return country;
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

    private void setId(int id) {
        this.id = id;
    }
}
