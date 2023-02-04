package com.jaeverba.jv.model.SqLite.service;

import com.jaeverba.jv.model.SqLite.entity.RequestEntity;
import com.jaeverba.jv.model.SqLite.repository.RequestRep;
import com.jaeverba.jv.utils.Random;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RequestService {
    private RequestRep requestRep;

    RequestService(
            RequestRep requestRep) {
        this.requestRep = requestRep;
    }

    @Transactional
    public int createRequest(RequestEntity solicitud) {
        int n = 0;

        try {
            if (!requestRep.existsByEmail(solicitud.getEmail())) {
                solicitud.setId(null == requestRep.findMaxId() ? 0 : requestRep.findMaxId() + 1);
                solicitud.setHora(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
                solicitud.setFecha(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
                solicitud.setCode(Random.password(20));
                requestRep.save(solicitud);
                n = 1;
            }
        } catch (Exception e) {
            throw e;
        }

        return n;
    }

    @Transactional
    public boolean delete(String email) {
        boolean borrado = false;

        try {
            requestRep.deleteByEmail(email);
            borrado = true;
        } catch (Exception e) {
            throw e;
        }

        return borrado;
    }

    public List<RequestEntity> getAll() {
        return requestRep.findAll();
    }
}
