class Product {
    String productId;
    String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class Main {
    public static void main(String[] args) {
        Product prod = new Product("P-1042", "Wireless Mouse");

        System.out.println("ProductId: " + prod.productId);
        System.out.println("ProductName: " + prod.productName);
    }
}