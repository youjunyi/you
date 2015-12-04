//package com.tt.web.type;
//
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
//import com.tt.entity.Type;
//import com.tt.service.zhekou.TypeService;
//
//@Controller
//@RequestMapping(value="/type")
//public class TypeController {
//	@Autowired
//	private TypeService ts;
//	private static final int PAGE_SIZE = 10;
//	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
//	static {
//		sortTypes.put("auto", "自动");
//		sortTypes.put("name", "名称");
//	}
//	@RequestMapping(value="save", method = RequestMethod.GET)	
//	public String save(Model modle){
//		System.out.println("type 看");
//		modle.addAttribute("type",new Type());
//		modle.addAttribute("action","save");
//		return "type/type";
//		
//	}
//	@RequestMapping(value="save",method = RequestMethod.POST)
//	public String savetj(@Valid Type newType ,RedirectAttributes redirectAttributes){
//		System.out.println("wo lai le");
//		System.out.println(newType.getBz());
//		ts.save(newType);
//		redirectAttributes.addFlashAttribute("message", "创建类型成功");
//		return "redirect:/type/";
//		
//	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String list(@RequestParam(value="sortType",defaultValue="auto") String sortType,
//			@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request){
//		System.out.println("ni shi  shui");
//		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//		Page<Type> type = ts.getTypeList(searchParams, pageNumber, PAGE_SIZE, sortType);
//		model.addAttribute("type",type);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		// 将搜索条件编码成字符串，用于排序，分页的URL
//		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//		return "type/typeList";
//		
//	}
//	@RequestMapping(value="update/{id}",method = RequestMethod.GET)
//	public String update(@PathVariable("id") Long id,Model model){
//		System.out.println("update");
//		model.addAttribute("type",ts.getTypeid(id));
//		model.addAttribute("action", "update");
//		return "type/type";
//		
//	}
//	@RequestMapping(value="update",method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("preloadType") Type type, RedirectAttributes redirectAttributes){
//		ts.save(type);
//		redirectAttributes.addFlashAttribute("message", "更新成功");
//		return "redirect:/type/";
//		
//	}
//	
//	@RequestMapping(value="delete/{id}",method = RequestMethod.GET)
//	public String delete(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
//		ts.delete(id);
//		redirectAttributes.addFlashAttribute("message", "删除成功");
//
//		return "redirect:/type/";
//		
//	}
//	
//	/**
//	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
//	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
//	 */
//	@ModelAttribute("preloadType")
//	public Type getTask(@RequestParam(value = "id", required = false) Long id) {
//		if (id != null) {
//			return ts.getTypeid(id);
//		}
//		return null;
//	}
//}
