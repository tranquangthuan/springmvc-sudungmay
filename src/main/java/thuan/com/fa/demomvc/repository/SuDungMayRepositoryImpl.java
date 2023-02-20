package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.entity.SuDungMay;
import thuan.com.fa.demomvc.entity.SuDungMayId;
import thuan.com.fa.demomvc.page.PageAble;

@Repository
public class SuDungMayRepositoryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<SuDungMay> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<SuDungMay> SuDungMays = session.createQuery("SELECT p FROM SuDungMay p", SuDungMay.class).getResultList();
		return SuDungMays;
	}

	public void saveOrUpdate(SuDungMay SuDungMay) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(SuDungMay);
	}

	public void delete(SuDungMay SuDungMay) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(SuDungMay);
	}

	public SuDungMay findById(SuDungMayId id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(SuDungMay.class, id);
	}

	public List<SuDungMay> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<SuDungMay> SuDungMays = session.createQuery("SELECT p FROM SuDungMay p", SuDungMay.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return SuDungMays;
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM SuDungMay p", Long.class).getSingleResult();
	}

	public List<SuDungMay> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<SuDungMay> createQuery = session.createQuery("SELECT p FROM SuDungMay p where p.name like :searchKey",
				SuDungMay.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<SuDungMay> SuDungMays = createQuery.getResultList();
		return SuDungMays;
	}

	public boolean existSerial(String serial) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query<Long> createQuery = session.createQuery("SELECT COUNT(*) FROM SuDungMay p WHERE p.serial=:serial",
				Long.class);
		createQuery.setParameter("serial", serial);
		long totalRecord = createQuery.getSingleResult();
		System.out.println("Total record with serial = " + totalRecord + " serial = " + serial);

		return totalRecord > 0;
	}
}
