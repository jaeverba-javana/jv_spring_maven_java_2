package com.jaeverba.jv.model.MySQL.repository;

import com.jaeverba.jv.model.MySQL.entity.ContactRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequestEntity, Integer> {
    public boolean existsById(int id);

    public boolean existsByEmail(String email);

    @Modifying
    @Query("delete  from ContactRequestEntity c where c.email = ?1")
    public void deleteByEmail(String email);

    public List<ContactRequestEntity> findById(int id);
    public List<ContactRequestEntity> findByEmail(String email);

    //delete from solicitud where id=?

    @Query("select max(s.id) from ContactRequestEntity s")
    public Integer findMaxId();
}
