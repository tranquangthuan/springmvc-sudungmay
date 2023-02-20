package thuan.com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuan.com.fa.demomvc.entity.May;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.repository.MayRepositoryImpl;

@Service
public class MayServiceImpl {

	@Autowired
	private MayRepositoryImpl repository;

	@Transactional
	public List<May> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void saveOrUpdate(May may) {
		repository.saveOrUpdate(may);
	}

	@Transactional
	public void delete(String id) {
		May May = findById(id);
		if (May != null) {
			repository.delete(May);
		}
	}

	@Transactional
	public May findById(String id) {
		return repository.findById(id);
	}

	@Transactional
	public List<May> findWithPageAble(PageAble pageAble) {
		return repository.findWithPageAble(pageAble);
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = repository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

}
