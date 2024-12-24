package com.emp_sphere.user_auth.model;



import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "employee_profile")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @Column(name = "street_address", length = 255)
    private String streetAddress;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "pincode", length = 10)
    private String pincode;

    @Column(name = "profile_picture", length = 255)
    private String profilePicture;

    @Column(name = "designation", length = 50)
    private String designation;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;

    // Constructors
    public EmployeeProfile() {}

    public EmployeeProfile(Integer userId, String fullname, String streetAddress, String country, String state, String city, String pincode, String profilePicture, String designation, Date dob, Integer age, String gender, Integer locationId) {
        this.userId = userId;
        this.fullname = fullname;
        this.streetAddress = streetAddress;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.profilePicture = profilePicture;
        this.designation = designation;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.locationId = locationId;
        this.updatedOn = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "EmployeeProfile{" +
                "employeeId=" + employeeId +
                ", userId=" + userId +
                ", fullname='" + fullname + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", designation='" + designation + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", locationId=" + locationId +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
