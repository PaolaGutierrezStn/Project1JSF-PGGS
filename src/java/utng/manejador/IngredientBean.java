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
import utng.model.Ingredient;

/**
 *
 * @author Paola
 */

@ManagedBean 
@SessionScoped
public class IngredientBean implements Serializable {
    private List<Ingredient> ingredients;
    private Ingredient ingredient;
   
   public IngredientBean(){
       
   }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
   
    public String list(){
        IngredientDAO dao = new IngredientDAO();
        try {
            ingredients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ingredients";
    }
    
    public String delete(){
         IngredientDAO dao = new IngredientDAO();
        try {
            dao.delete(ingredient);
            ingredients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        ingredient= new Ingredient();
        return "Start";
    }
    
    public String save(){
        IngredientDAO dao = new IngredientDAO();
        try {
            if(ingredient.getIdIngredient()!= 0){
                dao.update(ingredient);
            }else {
                dao.insert(ingredient);
            }
            ingredients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Ingredient ingredient){
        this.ingredient=ingredient;
        return "Edit";
    }
}