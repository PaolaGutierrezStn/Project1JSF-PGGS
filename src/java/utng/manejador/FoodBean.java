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
public class FoodBean implements Serializable{
    private List<Food>foods;
    private Food food;
    public List<Country> countries;

    public FoodBean(){
        food = new Food();
        food.setCountry(new Country());
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    

    
    
    
    
    public String list(){
        FoodDAO dao = new FoodDAO();
        try {
            foods=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Foods";
    }
    
    public String delete(){
         FoodDAO dao = new FoodDAO();
        try {
            dao.delete(food);
            foods=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        food = new Food();
        food.setCountry(new Country());
        try{
            countries = new CountryDAO().getAll();
        }catch(Exception e){
        e.printStackTrace();
    }
        return "Start";
    }
    
    public String save(){
        FoodDAO dao = new FoodDAO();
        try {
            if(food.getIdFood()!= 0){
                dao.update(food);
            }else {
                dao.insert(food);
            }
            foods=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Food food){
        this.food=food;
        try{
            countries = new CountryDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Edit";
}
}
