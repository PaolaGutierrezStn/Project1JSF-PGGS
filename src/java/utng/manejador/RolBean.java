package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.RolDAO;
import utng.model.Rol;

@ManagedBean
@SessionScoped
public class RolBean implements Serializable{
    private List<Rol>roles;
    private Rol rol;
    public RolBean(){}

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    public String list(){
        RolDAO dao = new RolDAO();
        try {
            roles=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Roles";
    }
    
    public String delete(){
         RolDAO dao = new RolDAO();
        try {
            dao.delete(rol);
            roles=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        rol= new Rol();
        return "Start";
    }
    
    public String save(){
        RolDAO dao = new RolDAO();
        try {
            if(rol.getIdRol()!= 0){
                dao.update(rol);
            }else {
                dao.insert(rol);
            }
            roles=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Rol rol){
        this.rol=rol;
        return "Edit";
    }
    
}
