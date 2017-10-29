/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejb;

import com.example.modelos.Autores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sponce
 */
@Stateless
public class AutoresFacade extends AbstractFacade<Autores> implements AutoresFacadeLocal {

    @PersistenceContext(unitName = "ExamleCRUD-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }
    
}
