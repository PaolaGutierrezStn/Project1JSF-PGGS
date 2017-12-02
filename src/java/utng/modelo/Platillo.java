/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Paola
 */

@Entity
@Table(name="platillo")
public class Platillo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_platillo")
    private Long idPlatillo;
    @Column(name="nombre", length=10)
    private String nombre;
    @Column(name="precio", length=10)
    private int precio;
    @Column(name="cocinero", length=10)
    private String cocinero;
    @ManyToOne()
    @JoinColumn(name="id_ingrediente")
    private Ingrediente ingrediente;

    public Platillo(Long idPlatillo, String nombre, int precio, String cocinero, Ingrediente ingrediente) {
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.precio = precio;
        this.cocinero = cocinero;
        this.ingrediente = ingrediente;
    }       
    
    public Platillo() {
        this.idPlatillo=0L;
    }

    public Long getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Long idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCocinero() {
        return cocinero;
    }

    public void setCocinero(String cocinero) {
        this.cocinero = cocinero;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    

    

    

    

    
    
}