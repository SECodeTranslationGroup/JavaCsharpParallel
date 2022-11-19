package parallel.linq101.datasource;


import java.util.List;

public class Customer {
    private String customerId;
    private String companyName;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private List<Order> orders;

    public static Customer DEFAULT = null;

    public Customer(String customerId, String companyName, String address, String city, String region, String postalCode, String country, String phone, List<Order> orders) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.orders = orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orders='" + orders.size() + '\'' +
                '}';
    }
}