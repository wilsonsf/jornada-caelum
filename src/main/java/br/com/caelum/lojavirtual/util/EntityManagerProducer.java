package br.com.caelum.lojavirtual.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit(unitName="jornadaDS", name="jornadaDS")
	private EntityManagerFactory factory;

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return this.factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		manager.close();
	}

}
