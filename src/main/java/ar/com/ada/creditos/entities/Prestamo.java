package ar.com.ada.creditos.entities;

import java.math.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamo_Id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    
    private BigDecimal importe;
    
    @Column(name = "cuotas")
    private int cuotas;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;


    public int getPrestamo_Id() { 
        return prestamo_Id;
    }

    public void setPrestamo_Id(int prestamoId) {
        this.prestamo_Id = prestamoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
       // this.cliente.agregarPrestamo(this);
    }

   // public Prestamo() {
        
  //  }
 

    
}
