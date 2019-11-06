/*
 * @author Aviendha O Broin
 * code based on  examples from @Frances Sheridan
 */
package RealEstate;

import java.io.Serializable;

public class Property implements Serializable {

    //when not manually set, java automatically generates a versionUID that can differ from the current versionUID when serialising classes
    private static final long serialVersionUID = -968231288339891817L;

    protected String owner;
    protected String address;
    protected double price;
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Property() {
        owner = new String();
        address = new String();
        price = 0.0;
        id = 0;
    }

    public Property(String owner, String address, double price, int id) {
        //overloaded constructor in super class to allow subclass to be passed values to its own overloaded constructor
        this.owner = owner;
        this.address = address;
        this.price = price;
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
