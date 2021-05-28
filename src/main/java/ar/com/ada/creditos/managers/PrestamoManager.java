package ar.com.ada.creditos.managers;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ar.com.ada.creditos.entities.*;


public class PrestamoManager {

	protected SessionFactory sessionFactory;

	public void setup() {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings
                                                                                                  // from
                                                                                                  // hibernate.cfg.xml
                
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    public void exit() {
        sessionFactory.close();
	}
	
	public void create(Prestamo prestamo) {
	
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(prestamo);

        session.getTransaction().commit();
        session.close();

    }
        
    
    public List<Prestamo> buscarTodos() {

        Session session = sessionFactory.openSession();

        Query query = session.createNativeQuery("SELECT * FROM prestamo", Prestamo.class);
        List<Prestamo> todos = query.getResultList();

        return todos;
    }


    public List<Prestamo> buscarPor(String nombre) {
        Session session = sessionFactory.openSession();

        Query query = session.createNativeQuery("SELECT * FROM cliente where nombre = '" + nombre + "'", Prestamo.class);

        List <Prestamo> prestamos = query.getResultList();

        return prestamos;
    }

		
	
    
}
