package thuan.com.fa.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thuan.com.fa.demomvc.entity.KhachHang;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.service.KhachHangServiceImpl;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

	@Autowired
	private KhachHangServiceImpl khachHangServiceImpl;

	@GetMapping("/list")
	public String getAllmayWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<KhachHang> khachHangs = khachHangServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("khachHangs", khachHangs);
		model.addAttribute("totalPages", khachHangServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/khachhang/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("khachHangForm", new KhachHang());
		return "/khachhang/new";
	}

	@PostMapping("/save")
	public String addNewmay(@ModelAttribute(name = "mayForm") @Valid KhachHang may, BindingResult result) {
		if (result.hasErrors()) {
			return "/khachhang/new";
		}
		khachHangServiceImpl.saveOrUpdate(may);
		return "redirect:/khachhang/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") String mayId) {
		khachHangServiceImpl.delete(mayId);
		return "redirect:/khachhang/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") String mayId, Model model) {
		KhachHang khachHang = khachHangServiceImpl.findById(mayId);
		model.addAttribute("khachHangForm", khachHang);
		return "/khachhang/new";
	}

}
