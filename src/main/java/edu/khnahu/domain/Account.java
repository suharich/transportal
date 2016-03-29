package edu.khnahu.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
//import java.util.Locale.

@Document
public class Account {

    //@Id
	//private ObjectId acc_id;

    @Id
    private String acc_id;

	private String loggin;
    private String email;
    // физическое лицо, юридическое лицо или частный предприниматель
	private String acc_type;
    // active, disable
	private String acc_status;
    
    private String acc_role;

    private String name;
    private String surname;
    private Date   birthday;

    private String phone1;
    private String phone2;
    private String phone3;

    private String language;
    private String country;
    private String region;
    private String city;

    public String getAccId() {
        return acc_id.toString();
    }
    public void setAccId(String value) {
        this.acc_id = value;
    }

    public String getLoggin() {
        return loggin;
    }
    public void setLoggin(String value) {
        this.loggin = value;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }


    public String getAccType() {
        return acc_type;
    }
    public void setAccType(String value) {
        this.acc_type = value;
    }

    public String getAccStatus() {
        return acc_status;
    }
    public void setAccStatus(String value) {
        this.acc_status = value;
    }

    public String getAccRole() { return acc_role; }
    public void setAccRole(String acc_role) { this.acc_role = acc_role; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getPhone1() { return phone1; }
    public void setPhone1(String phone1) { this.phone1 = phone1; }

    public String getPhone2() { return phone2; }
    public void setPhone2(String phone2) { this.phone2 = phone2; }

    public String getPhone3() { return phone3; }
    public void setPhone3(String phone3) { this.phone3 = phone3; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    //TODO: need to update according to new fields
	 @Override
	 public String toString() {
	  return "Account [acc_id=" + acc_id.toString() + ", loggin=" + loggin
	    + ", email=" + email + ", acc_type="
	    + acc_type +",acc_status="+ acc_status + "]";
	 }
	  

}
