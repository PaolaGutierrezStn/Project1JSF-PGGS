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
import javax.persistence.Table;

@Entity
@Table(name="ingrediente")
public class Ingrediente implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ingrediente")
    private Long idIngrediente;
    @Column(name="nombre", length=10)
    private String nombre;
    @Column(name="sabor", length=10)
    private String sabor;
    @Column(name="precio", length=10)
    private int precio;

    public Ingrediente(Long idIngrediente, String nombre, String sabor, int precio) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.sabor = sabor;
        this.precio = precio;
    }
    
    public Ingrediente() {
        this.idIngrediente=0L;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
    
    
}


    
   
