package manager;

import java.util.List;

import javax.persistence.EntityManager;

import models.Glumac;
import models.Karta;
import models.Posetilac;
import models.Uloga;

public class Controller {

	private static EntityManager em;
	
	static {
		em = JPAUtil.getEntityManager();
	}
	
	public static List<Uloga> getUlogeGlumca(String ime, String prezime) {
		String upit = "select u from Uloga u where u.glumac.ime like :ime and u.glumac.prezime like :prezime";
		return em.createQuery(upit, Uloga.class).setParameter("ime", ime).setParameter("prezime", prezime).getResultList();
	}
	
	public static Posetilac getPosetilacById(String idP) {
		Integer id = Integer.parseInt(idP);
		String upit = "select p from Posetilac p where p.id = :id";
		return em.createQuery(upit, Posetilac.class).setParameter("id", id).getSingleResult();
	}
	
	public static boolean isPlacenKarta(String idK) {
		Integer id = Integer.parseInt(idK);
		String upit = "select k from Karta k where k.id = :id";

		Karta k = em.createQuery(upit, Karta.class).setParameter("id", id).getSingleResult();
		
		if(k.getDatumPlacanja() != null)
			return true;
		else 
			return false;
	}
	
	public static void main(String args[]) {
		String upit = "select g from Glumac g";
		em.createQuery(upit, Glumac.class).getResultList().forEach(x -> System.out.println("Glumac " + x.getIme()));
	}
}
