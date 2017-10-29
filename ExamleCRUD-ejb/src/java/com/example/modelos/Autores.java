/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sponce
 */
@Entity
@Table(name = "Autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a")
    , @NamedQuery(name = "Autores.findByIDAutor", query = "SELECT a FROM Autores a WHERE a.iDAutor = :iDAutor")
    , @NamedQuery(name = "Autores.findByNombre", query = "SELECT a FROM Autores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Autores.findByApellido", query = "SELECT a FROM Autores a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Autores.findByEdad", query = "SELECT a FROM Autores a WHERE a.edad = :edad")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Autor")
    private Integer iDAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Edad")
    private Integer edad;

    public Autores() {
    }

    public Autores(Integer iDAutor) {
        this.iDAutor = iDAutor;
    }

    public Autores(Integer iDAutor, String nombre, String apellido, Integer edad) {
        this.iDAutor = iDAutor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getIDAutor() {
        return iDAutor;
    }

    public void setIDAutor(Integer iDAutor) {
        this.iDAutor = iDAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAutor != null ? iDAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.iDAutor == null && other.iDAutor != null) || (this.iDAutor != null && !this.iDAutor.equals(other.iDAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.modelos.Autores[ iDAutor=" + iDAutor + " ]";
    }
    
}
