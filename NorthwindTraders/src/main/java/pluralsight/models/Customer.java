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
        StringBuilder sb = new StringBuilder();
        sb.append("Company Name: ").append(companyName);
        sb.append("\nContact Name:\t").append(contactName);
        sb.append("\nCity:\t").append(city);
        sb.append("\nCountry:\t").append(country);
        sb.append("\nPhone:\t").append(phone);
        sb.append("\n-------------------");
        return sb.toString();
    }
}
