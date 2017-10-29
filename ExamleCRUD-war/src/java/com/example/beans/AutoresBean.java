package com.example.beans;

import com.example.ejb.AutoresFacadeLocal;
import com.example.modelos.Autores;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sponce
 */

@Named(value= "autoresBean")
@RequestScoped
public class AutoresBean {

    @EJB
    private AutoresFacadeLocal autoresFacade;
    private List<Autores> lstautores;
    private Autores autores;
    
    public AutoresBean() {
    } 
    
    @PostConstruct    
    public void init(){
        this.autores = new Autores();
        this.lstautores = this.autoresFacade.findAll();
    }
    
    public String cargar(Integer iDAutor, String nombre, String apellido, Integer edad){        
        this.autores.setIDAutor(iDAutor);
        this.autores.setNombre(nombre);
        this.autores.setApellido(apellido);
        this.autores.setEdad(edad);
        return "editarAutor";
    }   
    
    public String agregar(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.autoresFacade.create(autores);
        facesContext.addMessage(null, new FacesMessage("Datos insertados con exito","Confirmacion"));
        this.init();
        return "index";
    }
    
    public String editar(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.autoresFacade.edit(autores);
        facesContext.addMessage(null, new FacesMessage("Datos modificados con exito","Confirmacion"));
        this.autores = autores;
        this.init();
        return "index";
    }
    
    public String eliminar(Integer id){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        autores = this.autoresFacade.find(id);
        this.autoresFacade.remove(autores);
        facesContext.addMessage(null, new FacesMessage("Datos eliminados con exito","Confirmacion"));
        this.init();
        return "index";
    }

    public AutoresFacadeLocal getAutoresFacade() {
        return autoresFacade;
    }

    public void setAutoresFacade(AutoresFacadeLocal autoresFacade) {
        this.autoresFacade = autoresFacade;
    }

    public List<Autores> getLstautores() {
        return lstautores;
    }

    public void setLstautores(List<Autores> lstautores) {
        this.lstautores = lstautores;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }    
}
