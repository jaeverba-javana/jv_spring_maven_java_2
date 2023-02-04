package com.jaeverba.jv.model.SqLite.repository;

import com.jaeverba.jv.model.SqLite.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRep extends JpaRepository<RequestEntity, Integer> {
    public boolean existsById(int id);
    public boolean existsByEmail(String email);

    @Modifying
    @Query("delete from RequestEntity r where r.email = ?1")
    public void deleteByEmail(String email);

    public List<RequestEntity > findById(int id);
    public List<RequestEntity > findByEmail(String email);

    //delete from solicitud where id=?

    @Query("select max(r.id) from RequestEntity r")
    public Integer findMaxId();

}
