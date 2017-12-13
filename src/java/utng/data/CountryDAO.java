/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Country;

/**
 *
 * @author Paola
 */
public class CountryDAO extends DAO<Country> {
    public CountryDAO() {
        super(new Country());
    }

    
    public Country getOneById(Country country) throws HibernateException {
        return super.getOneById(country.getIdCountry()); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
