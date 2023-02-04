package com.jaeverba.jv.model.SQLite.service;

import com.jaeverba.jv.model.SqLite.service.RequestService;
import com.jaeverba.jv.model.SqLite.entity.RequestEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestTest {

    @Autowired
    private RequestService requestService;
    /*RequestTest(RequestService requestService) {
        this.requestService = requestService;
    }*/

    @Test
    public void crearDatos() {
        RequestEntity cre = new RequestEntity();
        cre.setNombres("Javier Eduardo Vergara");
        cre.setEmail("jaeverba2@gmail.com");
        cre.setMensaje("Hola, este es mi gran mensaje");


//        System.out.println(cre.toString());
        Assertions.assertEquals(1, requestService.createRequest(cre));
        Assertions.assertEquals(0, requestService.createRequest(cre));
    }
}
