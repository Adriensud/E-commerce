public class Main {
    public static void main(String[] args) {
        Order order = new Order(1002);
        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        // 1) Pas de remise, pas de port gratuit
        order.addItem(120.0);

        // 2) Seuil remise franchi (120 + 100 = 220 > 200)
        order.addItem(100.0);

        // 3) On ajoute 5 articles pour déclencher le port gratuit
        for (int i = 0; i < 5; i++) {
            order.addItem(10.0);
        }

        // Résumé final
        System.out.println("\n Total :");
        System.out.println(order);
    }
}
