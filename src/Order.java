import java.util.List;

public class Order {
    private final int id;
    private double totalPrice;
    private double shippingCost;
    private int itemCount;
    private final List<OrderObserver> observers;

    public Order(int id) {
        this.id = id;
        this.observers = null;    // initialisation minimale pour compiler
    }

    public void attach(OrderObserver o) {
    }

    public void detach(OrderObserver o) {
    }

    public void notifyObservers() {
    }

    public void addItem(double price) {
    }

    public int getItemCount() {
        return 0;
    }

    public double getTotalPrice() {
        return 0.0;
    }

    public double getShippingCost() {
        return 0.0;
    }

    public void setTotalPrice(double totalPrice) {
    }

    public void setShippingCost(double shippingCost) {
    }

    @Override
    public String toString() {
        return "";
    }
}
