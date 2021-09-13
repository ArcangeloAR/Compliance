//package automoveis.config;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import automoveis.model.Automovel;
//
//public class PersistidorDeAutomovel {
//
//	public static void main(String[] args) {
//
//		// FIND
//		
//		EntityManager em = JPAUtil.getEntityManager();
//		
//		Query q = em.createQuery("SELECT a FROM Automovel a", Automovel.class);
//		
//		List<Automovel> autos = q.getResultList();
//		
//		for(Automovel a : autos) {
//			System.out.println(a.getMarca());
//		}
		
		
		
		// INSERT

//		Automovel auto = new Automovel();
//		auto.setMarca("Ferrari");
//		auto.setModelo("F50");
//		auto.setAnoFabricacao(1995);
//		auto.setAnoModelo(1995);
//		auto.setObservacoes("Nunca foi batido");
//
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist(auto);
//		tx.commit();
		
		
		
		// DELETE
		
//		Automovel auto = new Automovel();
//		auto.setId((long) 1);
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.remove(auto);
//		tx.commit();
		
		
		
		// MODIFY
		
//		Automovel auto = new Automovel();
//		auto.setId((long) 1);
//		auto.setNome("F40");
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.merge(auto);
//		tx.commit();		
		
		
		
//		em.close();
//	}
//
//}
