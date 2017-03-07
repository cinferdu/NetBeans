/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatebd;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author cinthya.fernandez
 */
public class PersonaDAO {
    private Session sesion;
    private Transaction tx;
   
    private void manejaExcepcion(HibernateException he) throws HibernateException, SystemException
    {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
    public long guardarPersona(Persona pers) throws SystemException{
        long id=0;
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = (Transaction) sesion.beginTransaction();
            id = (Long) sesion.save(pers);
            tx.commit();
        }catch(HibernateException e){
            manejaExcepcion(e);
            throw e;
        } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | SystemException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sesion.close();
        return id;
    }
}
