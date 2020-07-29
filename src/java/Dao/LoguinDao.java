/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class LoguinDao {
    public Usuario encontrarUsuario(String username){
        //Tipo de dato: String, Integer
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE username='"+username+"'";
        Query query = session.createQuery(hql);
        Usuario usuario = (Usuario)query.uniqueResult(); //Cast
        return usuario;
        
    }
}
