public class QuantityObserver implements OrderObserver {
    private static final int FREE_SHIPPING_THRESHOLD = 5;

    @Override
    public void update(Order order) {
        if (order.getItemCount() > FREE_SHIPPING_THRESHOLD
                && order.getShippingCost() > 0) {
            order.setShippingCost(0.0);
            System.out.println("QuantityObserver : free shipping applied !");
        }
    }
}
