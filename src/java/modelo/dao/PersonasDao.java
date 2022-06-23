package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dominio.HibernateUtil;
import modelo.entities.Personas;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PersonasDao {
    public List<Personas> getAll(){
        List<Personas> lstpersonas = new ArrayList<>();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
         lstpersonas = sesion.createQuery("from Personas").list();
         ts.commit();
         sesion.close();
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }
        return lstpersonas;
    }
    
    public Personas getById(String id){
        Personas p = new Personas();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            p = (Personas) sesion.get(Personas.class, id);
            ts.commit();
            sesion.close();
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }       
        return p;
    }
    
    public boolean insertar(Personas p){
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(p);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }
        return resultado;
    }
    
    public boolean actualizar(Personas p){
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
           sesion.update(p);
           ts.commit();
           sesion.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }
        return resultado;
    }
    
    public boolean eliminar(Personas p){
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
           sesion.delete(p);
           ts.commit();
           sesion.close();
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            ts.rollback();
        }
        return resultado;
    }
}
