/*
 * @author Aviendha O Broin
 * code based on  examples from @Frances Sheridan
 */
package RealEstate;

public class Apartment extends Property {

    private int apartmentNum;

    public Apartment(String owner, String address, double price, int id, int apartmentNum) {
        super(owner, address, price, id);
        this.apartmentNum = apartmentNum;
    }

    public int getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(int apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

}
