package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.data.RolDAO;
import utng.data.ClientDAO;
import utng.model.Rol;
import utng.model.Client;

@ManagedBean(name="clientBean") 
@SessionScoped
public class ClientBean implements Serializable{
    private List<Client> clients;
    private Client client;
    private List<Rol> roles;
    
    public ClientBean(){
        client = new Client();
        client.setRol(new Rol());
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    

      
    
     public String list(){
        ClientDAO dao = new ClientDAO();
        try {
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Clients";
    }
    
    public String delete(){
         ClientDAO dao = new ClientDAO();
        try {
            dao.delete(client);
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        client= new Client();
        client.setRol(new Rol());
        try {
            roles= new RolDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        ClientDAO dao = new ClientDAO();
        try {
            if(client.getIdClient()!= 0){
                dao.update(client);
            }else {
                dao.insert(client);
            }
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Client client){
        this.client=client;
        try {
            roles = new RolDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
    public String login(){
        client = new ClientDAO().login(this.client);
        if(client != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("client",client);
            return "Right";
        }else {
            client = new Client();
            return "Incorrect";
        }
    }
    
    public String logout(){
        if(client!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        }
        
        client = new Client();
        return "Exit";
    }   
    
}
