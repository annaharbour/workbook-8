package pluralsight.models;

public class Customer {
    private String contactName;
    private String companyName;
    private String city;
    private String country;
    private String phone;

    public Customer(String contactName, String companyName, String city, String country, String phone) {
        this.contactName = contactName;
        this.companyName = companyName;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("\n%-40s%-40s%-40s%-40s%-40s", companyName, contactName, city, country, phone);}
}
