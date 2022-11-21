using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;

namespace Parallel.Linq101.DataSources;

public class Customer
{
    private string? _customerId;
    private string? _companyName;
    private string? _address;
    private string? _city;
    private string? _region;
    private string? _postalCode;
    private string? _country;
    private string? _phone;
    private List<Order>? _orders;

    public static Customer Default = null;
    public string? CustomerId
    {
        get => _customerId;
        set => _customerId = value;
    }

    public string? CompanyName
    {
        get => _companyName;
        set => _companyName = value;
    }

    public string? Address
    {
        get => _address;
        set => _address = value;
    }

    public string? City
    {
        get => _city;
        set => _city = value;
    }

    public string? Region
    {
        get => _region;
        set => _region = value;
    }

    public string? PostalCode
    {
        get => _postalCode;
        set => _postalCode = value;
    }

    public string? Country
    {
        get => _country;
        set => _country = value;
    }

    public string? Phone
    {
        get => _phone;
        set => _phone = value;
    }

    public List<Order>? Orders
    {
        get => _orders;
        set => _orders = value;
    }

    public override string ToString() =>
        $"{CustomerId} {CompanyName}\n{Address}\n{City}, {Region} {PostalCode} {Country}\n{Phone}";
}

public class Order
{
    private int _orderId;
    private DateTime _orderDate;
    private double _total;
    
    public static Order Default = null;
    public int OrderId
    {
        get => _orderId;
        set => _orderId = value;
    }

    public DateTime OrderDate
    {
        get => _orderDate;
        set => _orderDate = value;
    }

    public double Total
    {
        get => _total;
        set => _total = value;
    }

    public override string ToString() => $"{OrderId}: {OrderDate:d} for {Total:C2}";
}

public static class Customers
{
    public static List<Customer> CustomerList { get; } =
        (from e in XDocument.Parse(InputValues.CustomersXml).Root.Elements("customer")
            select new Customer
            {
                CustomerId = (string)e.Element("id"),
                CompanyName = (string)e.Element("name"),
                Address = (string)e.Element("address"),
                City = (string)e.Element("city"),
                Region = (string)e.Element("region"),
                PostalCode = (string)e.Element("postalcode"),
                Country = (string)e.Element("country"),
                Phone = (string)e.Element("phone"),
                Orders = (
                    from o in e.Elements("orders").Elements("order")
                    select new Order
                    {
                        OrderId = (int)o.Element("id"),
                        OrderDate = (DateTime)o.Element("orderdate"),
                        Total = (double)o.Element("total")
                    }).ToList()
            }).ToList();
}