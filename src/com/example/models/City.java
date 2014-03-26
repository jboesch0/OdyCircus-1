package com.example.models;

import com.example.jsonparserapi.*;
import java.io.IOException;

public class City {
	
	//Attributes
	private int id;
	private String name;
	private Country country;
	private float latitude;
	private float longitude;

    //Constructors
    public City(){
        this.name = "";
        this.country = null;
    }

	public City(int id, String name, Country country, float latitude, float longitude){
		this.id = id;
		this.name = name;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	//Methodes
    public static City getCity(int id) throws IOException, JSONException {
        City city;
        String address = "http://ns303921.ovh.net/~odycircu/api/location/city.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
            city = null;
        }
        else{
            city = new City(jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    Country.getCountry(jsonObject.getInt("country")),
                    (float) jsonObject.getDouble("latitude"),
                    (float) jsonObject.getDouble("longtitude"));
        }
        return city;
    }

    public static City addCity(String name, Country country, float latitude, float longitude) throws IOException {
        City city;
        String address = "http://ns303921.ovh.net/~odycircu/api/location/add_city.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&name=" +
                name +
                "&country=" +
                country.getId() +
                "&latitude=" +
                latitude +
                "&longitude=" +
                longitude;

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
            city = null;
        } else {
            city = new City();
            city.setId(jsonObject.getInt("id"));
            city.setName(name);
            city.setLatitude(latitude);
            city.setLongitude(longitude);
            System.out.println("Successfull !!");
        }
        return city;
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

    private void setId(int id) {
        this.id = id;
    }
}
