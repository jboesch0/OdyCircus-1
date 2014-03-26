package com.example.models;


import com.example.jsonparserapi.*;
import org.json.JSONException;

import java.io.IOException;

public class User {

    //Attributes
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String picture;

	//Constructors
	public User(){
        this.username = null;
        this.password = null;
        this.firstName = null;
        this.email = null;
        this.picture = null;
    }

	public User(int id, String username, String password, String firstName, String lastName, String email, String picture){
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.picture = picture;
	}

	//Methodes
    public static User getUser(int id) {
        User user;
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=" + id;
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = null;
        try {
            jsonObject = connection.connect(address);
            System.out.println(jsonObject.getBoolean("error"));
            if (jsonObject.getBoolean("error")) {
                System.err.println("Error" + jsonObject.getString("stack_trace"));
                user = null;
            }
            else{
                user = new User(jsonObject.getInt("id"),
                        jsonObject.getString("username"),
                        jsonObject.getString("password"),
                        jsonObject.getString("firstName"),
                        jsonObject.getString("lastName"),
                        jsonObject.getString("email"),
                        jsonObject.getString("picture"));
            }
        } catch (IOException e) {
            user = null;
        }
        return user;
    }

    public static int[] addUser(String username, String password, String email) {
        int[] exitcode;
        exitcode = new int[2];
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/add_user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&username=" +
                username +
                "&password=" +
                password +
                "&email=" +
                email;

        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = null;
        try {
            jsonObject = connection.connect(address);
            if (jsonObject.getBoolean("error")) {
                exitcode[0] = 1;
            }
            else{
                exitcode[0] = 0;
                exitcode[1] = jsonObject.getInt("id");
            }
        } catch (IOException e) {
            exitcode[0] = 2;
        }
        return exitcode;
    }

    public static void updateUser(int id, String username, String firstName, String lastName, String password, String email, String passwordToVerify) throws IOException, JSONException {
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/update_user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&" +
                "id=" +
                id+
                "&firstName=" +
                firstName +
                "&lastName=" +
                lastName +
                "&username=" +
                username +
                "&password1=" +
                password +
                "&password2=" +
                passwordToVerify +
                "&email=" +
                email;
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

    public static void deleteUser(int id) throws IOException, JSONException {
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

    public static int login(String username, String password) {
        int ret;
        String address = "http://ns303921.ovh.net/~odycircu/api/membership/login.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&username="
                + username
                + "&password="
                + password;
        JSONConnection connection = new JSONConnection();
        try {
            JSONObject jsonObject = connection.connect(address);
            if (jsonObject.getBoolean("error")) {
                ret = -2;
            } else {
                ret = jsonObject.getInt("connected");
            }
        } catch (IOException e){
            ret = -1;
        }
        return ret;
    }

	//Getters
	public int getId(){
		return id;
	}

	public String getUsername(){
		return username;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getEmail(){
		return email;
	}

	public String getPicture(){
		return picture;
	}

	//Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

    public String toString(){
        return "Id : " +
                id +
                "\nUsername : " +
                username +
                "\nPassword : " +
                password +
                "\nFirst Name : " +
                firstName +
                "\nLast Name : " +
                lastName +
                "\nEmail : " +
                email +
                "\nPicture : " +
                picture;
    }
}
