package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.entity.KhachHang;
import thuan.com.fa.demomvc.page.PageAble;

@Repository
public class KhachHangRepositoryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<KhachHang> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> KhachHangs = session.createQuery("SELECT m FROM KhachHang m", KhachHang.class).getResultList();
		return KhachHangs;
	}

	public void saveOrUpdate(KhachHang KhachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(KhachHang);
	}

	public void delete(KhachHang KhachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(KhachHang);
	}

	public KhachHang findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(KhachHang.class, id);
	}

	public List<KhachHang> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> KhachHangs = session.createQuery("SELECT m FROM KhachHang m", KhachHang.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return KhachHangs;
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM KhachHang m", Long.class).getSingleResult();
	}
}
