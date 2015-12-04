//package com.tt.web.renyuan;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletRequest;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springside.modules.web.Servlets;
//
//import com.google.common.collect.Maps;
//import com.tt.entity.Fengcheng;
//import com.tt.entity.Renyuan;
//import com.tt.entity.Zhekou;
//import com.tt.service.zhekou.FengchengService;
//import com.tt.service.zhekou.RenyuanService;
//
//@Controller
//@RequestMapping(value="/renyuan")
//public class RenyuanController {
//	@Autowired
//	private RenyuanService rys;
//	@Autowired
//	private FengchengService fcs;
//	private static final int PAGE_SIZE = 10;
//	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
//	static {
//		sortTypes.put("auto", "自动");
//		sortTypes.put("name", "名称");
//	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String list(@RequestParam(value="sortType",defaultValue="auto") String sortType,
//			@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request ){
//		System.out.println("ni shi  shui");
//		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Page<Renyuan> renyuan = rys.getRenyuan(searchParams, pageNumber, PAGE_SIZE, sortType);
//		model.addAttribute("renyuan", renyuan);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		// 将搜索条件编码成字符串，用于排序，分页的URL
//		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//
//		return "renyuan/renyuanList";
//		
//	}
//	
//	@RequestMapping(value="save", method = RequestMethod.GET)
//	public String save(Model modle){
//		List<Fengcheng> flist = fcs.getAll();
//		System.out.println("laile ren"+flist);
//		
//		modle.addAttribute("renyuan",new Renyuan());
//		modle.addAttribute("action","save");
//		modle.addAttribute("fengcheng",flist);
//		return "renyuan/renyuan";
//		
//	}
//	@RequestMapping(value="save",method = RequestMethod.POST)
//	public String savetj(@Valid Renyuan newRenyuan,@Valid Long fengchengs,  RedirectAttributes redirectAttributes){
//		
//		System.out.println("s"+fengchengs+newRenyuan.getType());
//		Fengcheng fencheng = fcs.getFengcheng(fengchengs);
//		newRenyuan.setFengcheng(fencheng);
//		rys.save(newRenyuan);
//		redirectAttributes.addFlashAttribute("message", "添加成功");
//
//		return "redirect:/renyuan/";
//		
//	}
//	@RequestMapping(value="update/{id}",method = RequestMethod.GET)
//	public String update(@PathVariable("id") Long id,Model model){
//		System.out.println("update");
//		List<Fengcheng> flist = fcs.getAll();
//		model.addAttribute("renyuan",rys.getRenyuanNoe(id));
//		model.addAttribute("action","update");
//		model.addAttribute("fengcheng",flist);
//		return "renyuan/renyuan";
//		
//	}
//	@RequestMapping(value="update",method = RequestMethod.POST )
//	public String update(@Valid  @ModelAttribute("preloadRenyuan") Renyuan renyuan,@Valid Long fengchengs, RedirectAttributes redirectAttributes){
//		Fengcheng fencheng = fcs.getFengcheng(fengchengs);
//		renyuan.setFengcheng(fencheng);
//		rys.save(renyuan);
//		redirectAttributes.addFlashAttribute("message", "更新成功");
//		return "redirect:/renyuan/";
//		
//	}
//	@RequestMapping(value="delete/{id}",method = RequestMethod.GET)
//	public String delete(@PathVariable("id")  Long id, RedirectAttributes redirectAttributes){
//		rys.delete(id);
//		redirectAttributes.addFlashAttribute("message", "删除成功");
//		return "redirect:/renyuan/";
//		
//	}
//	@ModelAttribute("preloadRenyuan")
//	public Renyuan getTask(@RequestParam(value = "id", required = false) Long id) {
//		if (id != null) {
//			return rys.getRenyuanNoe(id);
//		}
//		return null;
//	}
//}
