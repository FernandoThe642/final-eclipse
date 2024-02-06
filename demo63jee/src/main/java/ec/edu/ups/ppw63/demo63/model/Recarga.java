package ec.edu.ups.ppw63.demo63.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Recarga {

    @Id
    private int id;
    private String numeroTelefono;
    private String operador;
    private double monto;
    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaRecarga;
    
    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(Date fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }

    @Override
    public String toString() {
        return "Recarga [id=" + id + ", numeroTelefono=" + numeroTelefono + ", operador=" + operador + ", monto=" + monto + ", fechaRecarga=" + fechaRecarga + "]";
    }
    
   
