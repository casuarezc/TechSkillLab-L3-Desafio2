package org.example.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;
    private Order orderPrueba;
    private Order orderInvalida;
    private Order orderBlank;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderService = new OrderService(orderRepository);
        orderPrueba = new Order(100, "Orden prueba", "Cliente prueba");
        orderInvalida = new Order(101, null, "Cliente prueba");
        orderBlank = new Order(102, "", "Cliente prueba");
    }

    @Test
    void processOrder() {
        Mockito.when(orderRepository.saveOrder(Mockito.any(Order.class)))
                .thenReturn(orderPrueba.getId());
        int orderId = orderService.processOrder(orderPrueba);
        Assertions.assertEquals(orderId, orderPrueba.getId());
        Mockito.verify(orderRepository, Mockito.times(1))
                .saveOrder(orderPrueba);
    }

    @Test
    void retrieveOrder() {
    }

    @Test
    void updateOrder() {
    }
}