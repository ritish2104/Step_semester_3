import java.util.Scanner;

class ShoppingCart {
    private final String cartId;
    private double[] prices;
    private int itemCount;

    public ShoppingCart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cartId = sc.next();
        int capacity = sc.nextInt();
        int numItems = sc.nextInt();

        ShoppingCart cart = new ShoppingCart(cartId, capacity);
        for (int i = 0; i < numItems; i++) {
            double price = sc.nextDouble();
            cart.addItem(price);
        }

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());

        sc.close();
    }
}