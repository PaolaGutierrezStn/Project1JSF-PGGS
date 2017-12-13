package utng.data;

import org.hibernate.HibernateException;
import utng.model.Rol;


public class RolDAO extends DAO<Rol> {
     public RolDAO() {
        super(new Rol());
    }

    public Rol getOneById(Rol rol) throws HibernateException {
        return super.getOneById(rol.getIdRol()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
