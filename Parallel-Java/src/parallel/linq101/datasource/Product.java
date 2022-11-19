package parallel.linq101.datasource;

public class Product {
    public Integer productId;
    public String productName;
    public String category;
    public Double unitPrice;
    public Integer unitsInStock;

    public static Product DEFAULT = null;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Product(Integer productId, String productName, String category, Double unitPrice, Integer unitsInStock) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "(Product " +
                "id=" + productId +
                ", name=" + productName +
                ", cat=" + category +
                ", price=" + unitPrice +
                ", inStock=" + unitsInStock +
                ')';
    }
}