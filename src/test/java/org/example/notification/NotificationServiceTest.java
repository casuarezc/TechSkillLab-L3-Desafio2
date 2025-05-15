package org.example.notification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void sendNotification() {

        Mockito.when(notificationRepository.send(Mockito.any()))
                .thenReturn(true);

        var email = "correo@prueba.com";
        Assertions.assertTrue(notificationService.sendNotification(email));
        Mockito.verify(notificationRepository, Mockito.times(1))
                .send(email);

    }

    @Test
    void sendNotificationNull() {
        Mockito.when(notificationRepository.send(null))
                .thenReturn(false);

        Assertions.assertEquals(false, notificationService.sendNotification(null));
        Mockito.verify(notificationRepository, Mockito.times(0))
                .send(null);

    }

    @Test
    void sendNotificationBlank() {
        Mockito.when(notificationRepository.send(""))
                .thenReturn(false);

        Assertions.assertEquals(false, notificationService.sendNotification(""));
        Mockito.verify(notificationRepository, Mockito.times(0))
                .send("");

    }
}