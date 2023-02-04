package com.jaeverba.jv.model.MySQL.service;

import com.jaeverba.jv.model.MySQL.entity.ContactRequestEntity;
import com.jaeverba.jv.model.MySQL.repository.ContactRequestRepository;
import com.jaeverba.jv.utils.Random;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ContactRequestService {
    private ContactRequestRepository contactRequestRepository;

    ContactRequestService(
            ContactRequestRepository contactRequestRepository
    ) {
        this.contactRequestRepository = contactRequestRepository;
    }

    @Transactional
    public int createRequest(ContactRequestEntity cr) {
        int cont = 0;

        try {
            if(!contactRequestRepository.existsByEmail(cr.getEmail())) {
                cr.setFecha(new Timestamp(System.currentTimeMillis()));
                cr.setCode(Random.password(100));
                contactRequestRepository.save(cr);
                cont++;
            }
        } catch (Exception e) {
            throw e;
        }

        return cont;
    }
}
