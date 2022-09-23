package com.mycompany.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user")
public class User {
    
    @Id
    @Column(name="UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    
    @Basic
    @Column(name="EmailAddress")
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String emailAddress;
    
    @NotBlank
    @Basic
    @Column(name="Password")
    
    @Size(min = 8, max = 15)
    private String password;
    
    @NotBlank
    @Size(min = 3, max = 50)
    @Basic
    @Column(name="UserName")
    
    private String userName;
    
    @Basic
    @Column(name="Gender")
    @NotBlank
    private String gender;
    
    @Basic
    @Column(name="ContactNumber")
    private String contactNumber;
    
    @Basic
    @Column(name="Age")
    @Min(value = 0)
    @Max(value = 100)
    private int age;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public User() {
    }

   

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailAddress=" + emailAddress + ", password=" + password + ", userName="
				+ userName + ", gender=" + gender + ", contactNumber=" + contactNumber + ", age=" + age + "]";
	}
    
    

}
