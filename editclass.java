/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class editclass {
    private final int id;
    private String fullName;
    private String contactNumber;
    private String address;

    public editclass(int id, String fullName, String contactNumber, String address) {
        this.id = id;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Contact: " + contactNumber + ", Address: " + address;
    }
}
