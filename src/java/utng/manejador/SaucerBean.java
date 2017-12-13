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
import utng.data.IngredientDAO;
import utng.data.SaucerDAO;
import utng.model.Ingredient;
import utng.model.Saucer;

/**
 *
 * @author Paola
 */
@ManagedBean
@SessionScoped
public class SaucerBean implements Serializable {
    
    private List<Saucer> saucers;
    private Saucer saucer;
    private List<Ingredient> ingredients;
    public SaucerBean(){
        saucer = new Saucer();
        saucer.setIngredient(new Ingredient());
    }

    public List<Saucer> getSaucers() {
        return saucers;
    }

    public void setSaucers(List<Saucer> saucers) {
        this.saucers = saucers;
    }

    public Saucer getSaucer() {
        return saucer;
    }

    public void setSaucer(Saucer saucer) {
        this.saucer = saucer;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    

    
    
    public String list(){
        SaucerDAO dao = new SaucerDAO();
        try {
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Saucers";
    }
    
    public String delete(){
         SaucerDAO dao = new SaucerDAO();
        try {
            dao.delete(saucer);
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        saucer= new Saucer();
        saucer.setIngredient(new Ingredient());
        try{
            ingredients=new IngredientDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
        return "Start";
    }
    
    public String save(){
        SaucerDAO dao = new SaucerDAO();
        try {
            if(saucer.getIdSaucer()!= 0){
                dao.update(saucer);
            }else {
                dao.insert(saucer);
            }
            saucers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Saucer saucer){
        this.saucer=saucer;
        try{
            ingredients = new IngredientDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Edit";
    }
    
    
        
}
    
    
    
