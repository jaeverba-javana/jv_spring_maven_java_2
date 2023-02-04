package com.jaeverba.jv.model.SqLite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
public class RequestEntity {

    @Id
    @Getter
    @Setter
    private int id;

    @Getter @Setter
    private String mensaje;

    @Getter @Setter
    private String nombres;

    @Getter @Setter
    @Column(unique = true)
    private String email;

    @Getter @Setter
    private boolean aprobado;

    @Getter @Setter
    private String fecha;

    @Getter @Setter
    private String hora;

    @Getter @Setter
    @Column(unique = true, length = 20)
    private String code;

    public RequestEntity() {}
}
