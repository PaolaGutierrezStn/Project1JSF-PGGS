/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Ingredient;

/**
 *
 * @author Paola
 */
public class IngredientDAO extends DAO<Ingredient>{
    public IngredientDAO() {
        super(new Ingredient());
    }
    public Ingredient getOneById(Ingredient ingredient) throws HibernateException {
        return super.getOneById(ingredient.getIdIngredient()); 
    }
   
}
