package thuan.com.fa.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thuan.com.fa.demomvc.entity.KhachHang;
import thuan.com.fa.demomvc.entity.May;
import thuan.com.fa.demomvc.entity.SuDungMay;
import thuan.com.fa.demomvc.entity.SuDungMayId;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.service.KhachHangServiceImpl;
import thuan.com.fa.demomvc.service.MayServiceImpl;
import thuan.com.fa.demomvc.service.SuDungMayServiceImpl;

@Controller
@RequestMapping("/sudungmay")
public class SuDungMayController {

	@Autowired
	private SuDungMayServiceImpl suDungMayServiceImpl;

	@Autowired
	private MayServiceImpl mayServiceImpl;

	@Autowired
	private KhachHangServiceImpl khachHangServiceImpl;

	@GetMapping("/list")
	public String getAllSuDungMayWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<SuDungMay> suDungMays = suDungMayServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("suDungMays", suDungMays);
		model.addAttribute("totalPages", suDungMayServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/sudungmay/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("suDungMayForm", new SuDungMay());
		return "/sudungmay/new";
	}

	@PostMapping("/save")
	public String addNewSuDungMay(@ModelAttribute(name = "suDungMayForm") SuDungMay suDungMay, BindingResult result) {
		System.out.println(suDungMay);
		KhachHang khachHang = khachHangServiceImpl.findById(suDungMay.getId().getMaKH());
		suDungMay.setKhachHang(khachHang);
		May may = mayServiceImpl.findById(suDungMay.getId().getMaMay());
		suDungMay.setMay(may);
		if (result.hasErrors()) {
			return "/sudungmay/new";
		}
		suDungMayServiceImpl.saveOrUpdate(suDungMay);
		return "redirect:/sudungmay/list";
	}

	@GetMapping("/delete")
	public String delete(SuDungMayId suDungMayId) {
		System.out.println(" id = " + suDungMayId);
		suDungMayServiceImpl.delete(suDungMayId);
		return "redirect:/sudungmay/list";
	}

	@GetMapping("/update")
	public String update(SuDungMayId suDungMayId, Model model) {
		System.out.println(" id = " + suDungMayId);
		SuDungMay suDungMay = suDungMayServiceImpl.findById(suDungMayId);
		model.addAttribute("suDungMayForm", suDungMay);
		return "/sudungmay/update";
	}

	@PostMapping("/update")
	public String updateSuDungMay(@ModelAttribute(name = "SuDungMayForm") @Valid SuDungMay SuDungMay,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/sudungmay/update";
		}
		suDungMayServiceImpl.saveOrUpdate(SuDungMay);
		model.addAttribute("msgUpdate", "Update SuDungMay success");
		return "/sudungmay/update";
	}

	@ModelAttribute("mays")
	public List<May> initMays() {
		return mayServiceImpl.findAll();
	}

	@ModelAttribute("khachHangs")
	public List<KhachHang> initKhachHangs() {
		return khachHangServiceImpl.findAll();
	}

	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<SuDungMay> suDungMays = suDungMayServiceImpl.search(searchKey);
		model.addAttribute("suDungMays", suDungMays);
		model.addAttribute("searchKey", searchKey);

		return "/sudungmay/search";
	}
}
