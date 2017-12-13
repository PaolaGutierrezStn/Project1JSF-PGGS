/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.CountryDAO;
import utng.data.FoodDAO;
import utng.model.Country;
import utng.model.Food;

/**
 *
 * @author Paola
 */
@ManagedBean
@SessionScoped
public class CountryBean implements Serializable{
    private List<Country> countries;
    private Country country;
   

    public CountryBean() {
        
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

      
    
    public String list(){
        CountryDAO dao = new CountryDAO();
        try {
            countries=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Countries";
    }
    
    public String delete(){
         CountryDAO dao = new CountryDAO();
        try {
            dao.delete(country);
            countries=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        country= new Country();
        return "Start";
    }
    
    public String save(){
        CountryDAO dao = new CountryDAO();
        try {
            if(country.getIdCountry()!= 0){
                dao.update(country);
            }else {
                dao.insert(country);
            }
            countries=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Country country){
        this.country=country;
        return "Edit";
    }
    
    
    
}
