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
import utng.modelo.Ingrediente;

/**
 *
 * @author Paola
 */

@ManagedBean 
@SessionScoped
public class IngredienteBean implements Serializable {
    private List<Ingrediente> ingredientes;
    private Ingrediente ingrediente;
   
   public IngredienteBean(){
       
   }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
   
    public String listar(){
        IngredienteDAO dao = new IngredienteDAO();
        try {
            ingredientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ingredientes";
    }
    
    public String eliminar(){
         IngredienteDAO dao = new IngredienteDAO();
        try {
            dao.delete(ingrediente);
            ingredientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        ingrediente= new Ingrediente();
        return "Iniciar";
    }
    
    public String guardar(){
        IngredienteDAO dao = new IngredienteDAO();
        try {
            if(ingrediente.getIdIngrediente()!= 0){
                dao.update(ingrediente);
            }else {
                dao.insert(ingrediente);
            }
            ingredientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Ingrediente ingrediente){
        this.ingrediente=ingrediente;
        return "Editar";
    }
}