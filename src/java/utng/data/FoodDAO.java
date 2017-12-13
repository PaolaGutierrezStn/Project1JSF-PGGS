/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Food;

/**
 *
 * @author Paola
 */
public class FoodDAO  extends DAO<Food>{
    public FoodDAO(){
        super(new Food());
        
    }
    
    public Food getOneById(Food food) throws HibernateException {
        return super.getOneById(food.getIdFood()); //To change body of generated methods, choose Tools | Templates.
    }
    
}
