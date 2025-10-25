package ru.andr.javadaddy.advanced.test.topic2.task1;

public class OrderRepository {
    public void saveOrder(Order order) {
        // Заглушка для сохранения заказа в БД
        System.out.println("Заказ сохранен: " + order.getProductId());
    }
}
