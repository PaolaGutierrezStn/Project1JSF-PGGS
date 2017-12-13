/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Saucer;

/**
 *
 * @author Paola
 */
public class SaucerDAO extends DAO<Saucer> {
    public SaucerDAO() {
        super(new Saucer());
    }

    
    public Saucer getOneById(Saucer saucer) throws HibernateException {
        return super.getOneById(saucer.getIdSaucer()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
