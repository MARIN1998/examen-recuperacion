/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Producto;
import Modelo.Promocion;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class ValidarPromocion {
    public boolean buscarCodigo(String codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Promocion WHERE codigo='" + codigo + "'";
        Query query = session.createQuery(hql);
        Promocion promocion = (Promocion) query.uniqueResult();
        return promocion != null;

    }

    public Integer obtenerPrecio(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Producto WHERE nombre='" + nombre + "'";
        Query query = session.createQuery(hql);
        Producto producto = (Producto) query.uniqueResult();

        if (producto != null) {
            return producto.getPrecio();
          
        } else {
            return 0;
        }

    }
    
}
