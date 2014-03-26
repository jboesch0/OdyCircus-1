package com.example.models;

import com.example.jsonparserapi.*;
import java.io.IOException;
import java.util.Calendar;
//TODO : Gestion des dates
public class Event {
	
	//Attributes
	private int id;
	private City city;
    private Calendar fromDate;
    private Calendar toDate;
	private String description;
	private Circus circus;
	
	//Constructors
	public Event(){
        this.city = null;
        this.toDate = null;
        this.fromDate = null;
        this.description = "";
        this.circus = null;
    }

    public Event(int id, City city, Calendar fromDate,Calendar toDate, String description, Circus circus){
		this.id = id;
		this.description = description;
		this.circus = circus;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.city = city;
	}

    //Methodes
    public static Event getEvent(int id) throws IOException, JSONException {
        Event event;
        String address = "http://ns303921.ovh.net/~odycircu/api/activity/manage.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error" + jsonObject.getString("stack_trace"));
            event = null;
        }
        else {
            event = new Event();/*(jsonObject.getInt("id"),
                    City.getCity(jsonObject.getInt("city")),
                    jsonObject.getString("description"),
                    Circus.getCircus(jsonObject.getInt("circus")));
        */
        }
        return event;
    }

    public static Event addEvent(City city, Calendar fromDate, Calendar toDate, String description, Circus circus) throws IOException {
        Event event ;
        String address = "http://ns303921.ovh.net/~odycircu/api/activity/add_event.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&city=" +
                city.getId() +
                "&fromDate=" +
                //fromDate.toSql() +
                "&toDate" +
                //toDate.toSql() +
                "&description=" +
                description +
                "&circus=" +
                circus.getId();

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        System.out.println(jsonObject.getBoolean("error"));
        if (jsonObject.getBoolean("error")) {
            System.err.println("Error : " + jsonObject.getString("stack_trace"));
            event = null;
        }
        else{
            event = new Event();
            event.setId(jsonObject.getInt("id"));
            //event.setFromDate();
            //event.setToDate();
            event.setDescription(jsonObject.getString("description"));
            event.setCircus(Circus.getCircus(jsonObject.getInt("circus")));
            System.out.println("Successfull !!");
        }
        return event;
    }

    public static void updateEvent(int id, City city, Calendar fromDate, Calendar toDate, String description, Circus circus) throws IOException {
        String address = "http://ns303921.ovh.net/~odycircu/api/activity/update_event.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&" +
                "id=" +
                id +
                "city=" +
                city.getId() +
                "&fromDate=" +
                //fromDate.toSql() +
                "&toDate" +
                //toDate.toSql() +
                "&description=" +
                description +
                "&circus=" +
                circus.getId();
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

    public static void deleteEvent(int id) throws  IOException {
        String address = "http://ns303921.ovh.net/~odycircu/api/activity/delete_event.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
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

	//Getters
    public Calendar getFromDate() {
        return fromDate;
    }

    public Calendar getToDate() {
        return toDate;
    }

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

    private void setId(int id) {
        this.id = id;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }
}
