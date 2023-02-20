package thuan.com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuan.com.fa.demomvc.entity.KhachHang;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.repository.KhachHangRepositoryImpl;

@Service
public class KhachHangServiceImpl {

	@Autowired
	private KhachHangRepositoryImpl repository;

	@Transactional
	public List<KhachHang> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void saveOrUpdate(KhachHang KhachHang) {
		repository.saveOrUpdate(KhachHang);
	}

	@Transactional
	public void delete(String id) {
		KhachHang KhachHang = findById(id);
		if (KhachHang != null) {
			repository.delete(KhachHang);
		}
	}

	@Transactional
	public KhachHang findById(String id) {
		return repository.findById(id);
	}

	@Transactional
	public List<KhachHang> findWithPageAble(PageAble pageAble) {
		return repository.findWithPageAble(pageAble);
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = repository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

}
