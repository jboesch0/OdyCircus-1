package models;


import com.example.jsonapi.JSONConnection;
import com.example.jsonapi.JSONObject;
import org.json.JSONException;

import java.io.IOException;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Picture picture;
	
	
	
	public User(int id, String username, String password, String firstName, String lastName, String email, Picture picture){
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.picture = picture;
	}
	
	//Getters
	public int getId(){
		return id;
	}
	
	public String getUsername(){
		return username;
	}
	
	/* 
	 *  public String getPassword(){
	 *  
	 *  }
	 */
		
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public Picture getPicture(){
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
	
	public void setPicture(Picture picture){
		this.picture = picture;
	}

    public User getUser(int id) throws IOException, JSONException {
        User user = null;
        String address = String.format("http://ns303921.ovh.net/~odycircu/api/membership/user.php?key=b0ecf9e121bce55cfb5fc95eef9822a7e6b1fc72&id=%d", id);
        JSONConnection connection = new JSONConnection();
        JSONObject jsonObject = connection.connect(address);
        if (jsonObject.getBoolean("error")) {
            System.out.println("Error");
        }
        else{
            user.setId(jsonObject.getInt("id"));
            user.setUsername(jsonObject.getString("username"));
            user.setPassword(jsonObject.getString("password"));
            user.setFirstName(jsonObject.getString("firstName"));
            user.setLastName(jsonObject.getString("lastName"));
            user.setEmail(jsonObject.getString("email"));
            // Gestion Bancale !!
            user.setPicture((Picture)jsonObject.get("picture"));
        }
        return user;
    }
}
