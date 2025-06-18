import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private double totalPrice;
    private double shippingCost;
    private int itemCount;
    private final List<OrderObserver> observers;

    public Order(int id) {
        this.id = id;
        this.totalPrice = 0.0;
        this.shippingCost = 10.0; // coût de port par défaut
        this.itemCount = 0;
        this.observers = new ArrayList<>();
    }

    public void attach(OrderObserver o) {
        observers.add(o);
    }

    public void detach(OrderObserver o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (OrderObserver o : observers) {
            o.update(this);
        }
    }

    public void addItem(double price) {
        this.totalPrice += price;
        this.itemCount++;
        System.out.printf("Add an item to %.2f € → total=%.2f €, nbArticles=%d, port=%.2f €%n",
                price, totalPrice, itemCount, shippingCost);
        notifyObservers();
    }

    // getters et setters exposés pour les observers
    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, totalPrice=%.2f €, itemCount=%d, shippingCost=%.2f €]",
                id, totalPrice, itemCount, shippingCost
        );
    }
}
