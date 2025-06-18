public class PriceObserver implements OrderObserver {
    private static final double DISCOUNT_THRESHOLD = 200.0;
    private static final double DISCOUNT_AMOUNT    = 20.0;

    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > DISCOUNT_THRESHOLD) {
            double newTotal = order.getTotalPrice() - DISCOUNT_AMOUNT;
            order.setTotalPrice(newTotal);
            System.out.printf(
                    "PriceObserver : discount : %.2f € applied → new total=%.2f €%n",
                    DISCOUNT_AMOUNT, newTotal
            );
        }
    }
}
