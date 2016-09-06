package entrega3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import entrega2.Usuario;
import entrega4.Perro;
import entrega4.Persona;

public class FabricaDeDB {

	private static FabricaDeDB instance = null;

	public static FabricaDeDB getInstance() {
		if (instance == null) {
			instance = new FabricaDeDB();
		}
		return instance;
	}

	public Usuario obtenContacto(String nombre) {
		Usuario u;

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class)
				.buildSessionFactory();
		Session sesion = null;
		try {
			sesion = factory.getCurrentSession();
		} catch (org.hibernate.HibernateException he) {
			sesion = factory.openSession();
		}

		try {
			sesion.beginTransaction();
			u = (Usuario) sesion.get(Usuario.class, nombre);
		} finally {
			factory.close();
		}
		return u;
	}

	EntityManager entityManager;
	EntityTransaction tx;

	public FabricaDeDB() {
		entityManager = PerThreadEntityManagers.getEntityManager();
		tx = entityManager.getTransaction();
	}

	public void crearPerro(Perro perro) {

		tx.begin();
		entityManager.persist(perro);
		tx.commit();
	}

	public void crearPersona(Persona persona) {

		tx.begin();
		entityManager.persist(persona);
		tx.commit();
	}

	public Usuario usuarioLogueado(String nombre) {

		Usuario usuario = entityManager.find(Usuario.class, nombre);
		return usuario;
	}

	public void crearUsuario(Usuario user) {
		tx.begin();
		entityManager.persist(user);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsersNotAdmins() {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u where esAdmin = '0'");
		return (List<Usuario>) query.getResultList();
	}

}
