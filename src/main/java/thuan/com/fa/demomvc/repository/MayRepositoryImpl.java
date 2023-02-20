package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.entity.May;
import thuan.com.fa.demomvc.page.PageAble;

@Repository
public class MayRepositoryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<May> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<May> Mays = session.createQuery("SELECT m FROM May m", May.class).getResultList();
		return Mays;
	}

	public void saveOrUpdate(May May) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(May);
	}

	public void delete(May May) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(May);
	}

	public May findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(May.class, id);
	}

	public List<May> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<May> Mays = session.createQuery("SELECT m FROM May m", May.class).setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return Mays;
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM May m", Long.class).getSingleResult();
	}
}
