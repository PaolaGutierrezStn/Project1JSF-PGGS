package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_module")
    private Long idModule;
    @Column(name="name", length=100)
    private String name;
    @Column(length=150)
    private String route;

    public Module(Long idModule, String name, String route) {
        this.idModule = idModule;
        this.name = name;
        this.route = route;
    }
    
        public Module() {
        this(0L,"","");//al cominezo es cero o e una letra O
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
        
    
        
}