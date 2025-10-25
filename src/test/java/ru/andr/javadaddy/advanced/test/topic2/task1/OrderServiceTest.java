package ru.andr.javadaddy.advanced.test.topic2.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processOrder_success() {
        Order order = new Order("111", 10, 100.00);

        when(inventoryService.isProductAvailable(order.getProductId(), order.getQuantity())).thenReturn(true);

        assertTrue(orderService.processOrder(order));

        verify(inventoryService, times(1)).isProductAvailable(order.getProductId(), order.getQuantity());
        verify(orderRepository, times(1)).saveOrder(order);
    }

    @Test
    void processOrder_rejection() {
        Order order = new Order("111", 10, 100.00);

        when(inventoryService.isProductAvailable(order.getProductId(), order.getQuantity())).thenReturn(false);

        assertFalse(orderService.processOrder(order));

        verify(inventoryService, times(1)).isProductAvailable(order.getProductId(), order.getQuantity());
    }
}
