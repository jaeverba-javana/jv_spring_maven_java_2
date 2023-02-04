package com.jaeverba.jv.model.MySQL.service;

import com.jaeverba.jv.model.MySQL.entity.ContactRequestEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContactRequestServiceTest {
//    private ContactRequestService crs;

    @Autowired
    private ContactRequestService crs;

    @Test
    public void crearDatos() {
        ContactRequestEntity cre = new ContactRequestEntity();
        cre.setNombre("Javier Eduardo Vergara");
        cre.setEmail("jaeverba2@gmail.com");
        cre.setMensaje("Hola, este es mi gran mensaje");


//        System.out.println(cre.toString());
        Assertions.assertEquals(1, crs.createRequest(cre));
        Assertions.assertEquals(0, crs.createRequest(cre));
    }
}
