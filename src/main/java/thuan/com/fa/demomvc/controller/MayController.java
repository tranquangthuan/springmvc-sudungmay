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

import thuan.com.fa.demomvc.entity.May;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.service.MayServiceImpl;

@Controller
@RequestMapping("/may")
public class MayController {

	@Autowired
	private MayServiceImpl mayServiceImpl;

	@GetMapping("/list")
	public String getAllmayWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<May> mays = mayServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("mays", mays);
		model.addAttribute("totalPages", mayServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/may/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("mayForm", new May());
		return "/may/new";
	}

	@PostMapping("/save")
	public String addNewmay(@ModelAttribute(name = "mayForm") @Valid May may, BindingResult result) {
		if (result.hasErrors()) {
			return "/may/new";
		}
		mayServiceImpl.saveOrUpdate(may);
		return "redirect:/may/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") String mayId) {
		mayServiceImpl.delete(mayId);
		return "redirect:/may/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") String mayId, Model model) {
		May may = mayServiceImpl.findById(mayId);
		model.addAttribute("mayForm", may);
		return "/may/new";
	}

}
