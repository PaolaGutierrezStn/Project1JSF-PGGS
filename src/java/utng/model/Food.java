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
@Table(name="food")
public class Food  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_food")
    private Long idFood;
    @Column(name="name", length=10)
    private String name;
    @Column(name="description", length=10)
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="type", length=10)
    private String type;
    @ManyToOne()
    @JoinColumn(name="id_country")
    private Country country;

    public Food(Long idFood, String name, String description, int price, String type, Country country) {
        this.idFood = idFood;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.country = country;
    }
    
    public Food(){
        this.idFood=0L;
    }

    public Long getIdFood() {
        return idFood;
    }

    public void setIdFood(Long idFood) {
        this.idFood = idFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    
    
    
    
    
    
}
