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
import utng.datos.IngredienteDAO;
import utng.datos.PlatilloDAO;
import utng.modelo.Ingrediente;
import utng.modelo.Platillo;

/**
 *
 * @author Paola
 */
@ManagedBean
@SessionScoped
public class PlatilloBean implements Serializable {
    
    private List<Platillo> platillos;
    private Platillo platillo;
    private List<Ingrediente> ingredientes;
    public PlatilloBean(){
        platillo = new Platillo();
        platillo.setIngrediente(new Ingrediente());
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }
    
    public List<Ingrediente> getIngredientes(){
        return ingredientes;
    }
    
    public void setIngredientes(List<Ingrediente> ingredientes){
        this.ingredientes = ingredientes;
    }
    
    public String listar(){
        PlatilloDAO dao = new PlatilloDAO();
        try {
            platillos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Platillos";
    }
    
    public String eliminar(){
         PlatilloDAO dao = new PlatilloDAO();
        try {
            dao.delete(platillo);
            platillos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";//no me queda claro si este es es lo que devuelve 
    }
    
    public String iniciar(){
        platillo= new Platillo();
        platillo.setIngrediente(new Ingrediente());
        try{
            ingredientes=new IngredienteDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
        return "Iniciar";
    }
    
    public String guardar(){
        PlatilloDAO dao = new PlatilloDAO();
        try {
            if(platillo.getIdPlatillo()!= 0){
                dao.update(platillo);
            }else {
                dao.insert(platillo);
            }
            platillos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Platillo platillo){
        this.platillo=platillo;
        try{
            ingredientes = new IngredienteDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Editar";
    }
    
    
        
}
    
    
    
