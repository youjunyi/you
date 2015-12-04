//package com.tt.web.shangpin;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springside.modules.web.Servlets;
//
//import com.google.common.collect.Maps;
//
//import com.tt.entity.Shangpin;
//import com.tt.entity.Type;
//import com.tt.entity.Zhekou;
//import com.tt.service.zhekou.ShangpinService;
//import com.tt.service.zhekou.TypeService;
//
//@Controller
//@RequestMapping(value="/shangpin")
//public class ShangpinController {
//	@Autowired
//	private ShangpinService sps;
//	@Autowired
//	private TypeService ts;
//	private static final int PAGE_SIZE = 10;
//	
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
//		Page<Shangpin> shangpin = sps.getShangpin(searchParams, pageNumber, PAGE_SIZE, sortType,null);
//		model.addAttribute("shangpin", shangpin);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		// 将搜索条件编码成字符串，用于排序，分页的URL
//		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//
//		
//		return "shangpin/shangpinList";
//		
//	}
//	@RequestMapping(value="save",method = RequestMethod.GET)
//	public String save(Model model){
//		System.out.println("laile ");
//		List<Type> type = ts.getAll();
//		model.addAttribute("shangpin",new Shangpin());
//		model.addAttribute("type",type);
//		model.addAttribute("action","save");
//		return "shangpin/shangpin";
//	}
//	@RequestMapping(value="save",method = RequestMethod.POST)
//	public String savetj(@Valid Shangpin newshangpin,@Valid Long typex,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
//		System.out.println("wo lai le");
//		Type type = ts.getTypeid(typex);
//		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
//		String imgname =  image.getOriginalFilename();
//		String path = request.getSession().getServletContext().getRealPath("upload");  
//		FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
//		System.out.println(path);
//		newshangpin.setPath("/upload/"+imgname);
//		}
//		newshangpin.setTypes(type);
//		sps.save(newshangpin);
//		
//		redirectAttributes.addFlashAttribute("message", "添加成功");
//		return "redirect:/shangpin/";
//	}
//	@RequestMapping(value="update/{id}",method = RequestMethod.GET)
//	public String update(@PathVariable("id") Long id,Model model){
//		System.out.println("update");
//		List<Type> type = ts.getAll();
//
//		model.addAttribute("shangpin",sps.getShangpinNoe(id));
//		model.addAttribute("action","update");
//		model.addAttribute("type",type);
//		return "shangpin/shangpin";
//		
//	}
//	@RequestMapping(value="update",method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("preloadShangpin") Shangpin shangpin,@Valid Long typex,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
//		Type type = ts.getTypeid(typex);
//		System.out.println(image);
//		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
//		String imgname =  image.getOriginalFilename();
//		String path = request.getSession().getServletContext().getRealPath("upload");  
//		FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
//		System.out.println(path);
//		shangpin.setPath("/upload/"+imgname);
//		}
//		shangpin.setTypes(type);
//		sps.save(shangpin);
//		redirectAttributes.addFlashAttribute("message", "更新成功");
//
//		return "redirect:/shangpin/";
//		
//	}
//	@RequestMapping(value="delete/{id}",method = RequestMethod.GET)
//	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
//		sps.delete(id);
//		redirectAttributes.addFlashAttribute("message", "删除成功");
//
//		return "redirect:/shangpin/";
//		
//	}
//	/**
//	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
//	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
//	 */
//	@ModelAttribute("preloadShangpin")
//	public Shangpin getTask(@RequestParam(value = "id", required = false) Long id) {
//		if (id != null) {
//			return sps.getShangpinNoe(id);
//		}
//		return null;
//	}
//	
//	/**
//	 * Ajax请求校验loginName是否唯一。
//	 */
//	
//	@RequestMapping(value = "checkWid")
//	@ResponseBody
//	public String checkWid(@RequestParam("oldWid") String oldWid,
//			@RequestParam("wid") String wid) {
//		System.out.println("you"+wid+"uu"+oldWid);
//		if (wid.equals(oldWid)) {
//			return "true";
//		} else if (sps.findWid(wid) == null) {
//			return "true";
//		} else {
//			return "false";
//		}
//	}
//	@RequestMapping(value = "checkName")
//	@ResponseBody
//	public String checkName(@RequestParam("oldName") String oldName,
//			@RequestParam("name") String name) {
//		if (name.equals(oldName)) {
//			return "true";
//		} else if (sps.findName(name) == null) {
//			return "true";
//		} else {
//			return "false";
//		}
//	}
//}
