/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

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
@Table(name="country")
public class Country implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_country")
    private Long idCountry;
    @Column(name="name", length=10)
    private String name;
    @Column(name="culture", length=10)
    private String culture;
    

    public Country(Long idCountry, String name, String culture) {
        this.idCountry = idCountry;
        this.name = name;
        this.culture = culture;
    }

    
    
    public Country() {
        this.idCountry=0L;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

   
    }

    
    
    
    
    
    
