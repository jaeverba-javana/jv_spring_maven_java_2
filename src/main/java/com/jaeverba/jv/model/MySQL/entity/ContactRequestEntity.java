package com.jaeverba.jv.model.MySQL.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Entity
@Table(name = "contact_request", schema = "jv", catalog = "")
public class ContactRequestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contact_request", nullable = false)
    private int id;
    @Basic
    @Column(name = "mensaje", nullable = false, length = -1)
    private String mensaje;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "aprobado", nullable = false)
    private byte aprobado;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;
    @Basic
    @Column(name = "code", nullable = false, length = 255)
    private String code;

    public int getIdContactRequest() {
        return id;
    }

    public void setIdContactRequest(int idContactRequest) {
        this.id = idContactRequest;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAprobado() {
        return aprobado;
    }

    public void setAprobado(byte aprobado) {
        this.aprobado = aprobado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactRequestEntity that = (ContactRequestEntity) o;

        if (id != that.id) return false;
        if (aprobado != that.aprobado) return false;
        if (mensaje != null ? !mensaje.equals(that.mensaje) : that.mensaje != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) aprobado;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
