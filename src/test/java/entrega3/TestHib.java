package entrega3;

import javax.persistence.EntityManager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import entrega4.Perro;

public class TestHib extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void contextUp() {
		assertNotNull(entityManager());
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {
		});
	}

	@Test
	public void getDelVehiculo() {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();

		//Perro perro = entityManager.find(Perro.class, 1);

	}

}
