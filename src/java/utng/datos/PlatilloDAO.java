/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Platillo;

/**
 *
 * @author Paola
 */
public class PlatilloDAO extends DAO<Platillo> {
    public PlatilloDAO() {
        super(new Platillo());
    }

    
    public Platillo getOneById(Platillo platillo) throws HibernateException {
        return super.getOneById(platillo.getIdPlatillo()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
