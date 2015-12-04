package com.tt.web.guanli;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;
import com.tt.entity.Advice;
import com.tt.entity.CosmeticType;
import com.tt.entity.Cosmetics;
import com.tt.entity.ZiXun;
import com.tt.service.app.MptService;
import com.tt.service.guanli.GuanLiService;

@Controller
@RequestMapping("gl")
public class GuanliControlle {
	@Autowired
	private GuanLiService gls;
	@Autowired
	private MptService mpts;

	private static final int PAGE_SIZE = 10;
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	@RequestMapping(value="shouye")
	public ModelAndView shuye(){
		ModelAndView mav = new ModelAndView("account/insdex");
		return mav;
	}
	@RequestMapping(value="spzx")
	public String spzx(@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request){
		Page<ZiXun> zixun = gls.getFengcheng( pageNumber, PAGE_SIZE);
		model.addAttribute("zixun", zixun);
		return "spzx/spzx";
	}
	@RequestMapping(value="deletezx/{id}",method = RequestMethod.GET)
	public String deletezx(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
		gls.deletezx(id);
		redirectAttributes.addFlashAttribute("message", "删除咨讯成功");
		return "redirect:/gl/spzx";
		
	}
	@RequestMapping(value="updatezx/{id}",method = RequestMethod.GET)
	public String updatezx(@PathVariable("id") Long id,Model model,ServletRequest request){
		model.addAttribute("zixun", gls.getzixun(id));
		model.addAttribute("action","updatezx");
		return "spzx/spzxupdate";
		
	}
	@RequestMapping(value="savezx",method = RequestMethod.GET)
	public String savezx(Model model){
		model.addAttribute("zixun",new ZiXun());
		model.addAttribute("action","savezx");
		return "spzx/spzxupdate";
	}
	
	@RequestMapping(value="savezx",method = RequestMethod.POST)
	public String savezx(@Valid ZiXun zixun,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
			String imgname =  image.getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("upload");  
			FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
			System.out.println(path);
			zixun.setImg_url("/upload/"+imgname);
			}	
		gls.savezx(zixun);
		redirectAttributes.addFlashAttribute("message", "添加咨讯成功");

		return "redirect:/gl/spzx";
	}
	@RequestMapping(value="updatezx",method = RequestMethod.POST)
	public String updatezx(@Valid @ModelAttribute("preloadZiXun") ZiXun zixun,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
			String imgname =  image.getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("upload");  
			FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
			System.out.println(path);
			zixun.setImg_url("/upload/"+imgname);
			}	
		gls.savezx(zixun);
		redirectAttributes.addFlashAttribute("message", "更新咨讯成功");

		
		return "redirect:/gl/spzx";
		
	} 
	@ModelAttribute("preloadZiXun")
	public ZiXun getTask(@RequestParam(value = "zixun_type_id", required = false) Long id) {
		if (id != null) {
			return gls.getzixun(id);
		}
		return null;
	}
	@RequestMapping("listctype")
	public String listctype(@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request){
		Page<CosmeticType> costype = gls.getpagecostype( pageNumber, PAGE_SIZE);
		model.addAttribute("costype", costype);
		return "spzx/listctype";
		
	}
	@RequestMapping(value="deletetype/{id}",method = RequestMethod.GET)
	public String deletetype(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
		gls.deletetype(id);
		redirectAttributes.addFlashAttribute("message", "删除类型成功");
		return "redirect:/gl/listctype";
		
	}
	@RequestMapping(value="updatetype/{id}",method = RequestMethod.GET)
	public String updatetype(@PathVariable("id") Long id,Model model,ServletRequest request){
		model.addAttribute("costype", gls.getcostype(id));
		model.addAttribute("action","updatetype");
		return "spzx/costypeupdate";
		
	}
	@RequestMapping(value="savetyep",method = RequestMethod.GET)
	public String savetyep(Model model){
		model.addAttribute("costype",new CosmeticType());
		model.addAttribute("action","savetyep");
		return "spzx/costypeupdate";
	}
	@RequestMapping(value="savetyep",method = RequestMethod.POST)
	public String savetype(CosmeticType cosmeticType,RedirectAttributes redirectAttributes) throws IOException{
		gls.savetype(cosmeticType);
		redirectAttributes.addFlashAttribute("message", "添加类型成功");
		return "redirect:/gl/listctype";
	}
	@RequestMapping(value="updatetype",method = RequestMethod.POST)
	public String updatetype(CosmeticType cosmeticType,RedirectAttributes redirectAttributes) throws IOException{
		gls.savetype(cosmeticType);
		redirectAttributes.addFlashAttribute("message", "更新类型成功");
		return "redirect:/gl/listctype";
	}
	@ModelAttribute("preloadCosmeticType")
	public CosmeticType getTask1(@RequestParam(value = "zixun_type_id", required = false) Long id) {
		if (id != null) {
			return gls.getcostype(id);
		}
		return null;
	}
	@RequestMapping(value="listcos")
	public String listcos(@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request){
		Page<Cosmetics> page =  gls.getlistcos(pageNumber, PAGE_SIZE);
		model.addAttribute("page", page);
		return "spzx/listcos";
	}
	@RequestMapping(value="deletecos/{id}",method = RequestMethod.GET)
	public String deletecos(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
		gls.deletecos(id);
		redirectAttributes.addFlashAttribute("message", "删除商品成功");
		return "redirect:/gl/listcos";
		
	}
	@RequestMapping(value="updatecos/{id}",method = RequestMethod.GET)
	public String updatecos(@PathVariable("id") Long id,Model model,ServletRequest request){
		List<CosmeticType> cosmeticType = gls.getcostypeList(); 
		model.addAttribute("cosmeticType", cosmeticType);
		model.addAttribute("cos", gls.getcos(id));
		model.addAttribute("action","updatecos");
		return "spzx/cosupdate";
		
	}
	@RequestMapping(value="savecos",method = RequestMethod.GET)
	public String savecos(Model model){
		List<CosmeticType> cosmeticType = gls.getcostypeList(); 
		model.addAttribute("cosmeticType", cosmeticType);
		model.addAttribute("cos",new Cosmetics());
		model.addAttribute("action","savecos");
		return "spzx/cosupdate";
	}
	@RequestMapping(value="savecos",method = RequestMethod.POST)
	public String savecos(@Valid Cosmetics cosmetics,@Valid Long typex,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
		CosmeticType type = gls.getcostype(typex);
		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
			String imgname =  image.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("upload");  
		FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
		System.out.println(path);
		cosmetics.setCosmetics_img("/upload/"+imgname);
		}
		cosmetics.setCosmeticstype(type);
		gls.savecos(cosmetics);	
		redirectAttributes.addFlashAttribute("message", "添加商品成功");
		return "redirect:/gl/listcos";
	}
	@RequestMapping(value="updatecos",method = RequestMethod.POST)
	public String updatecos(@Valid @ModelAttribute("preloadCosmetics")Cosmetics cosmetics ,@Valid Long typex,@RequestParam("file") MultipartFile image,RedirectAttributes redirectAttributes,HttpServletRequest request) throws IOException{
		CosmeticType type = gls.getcostype(typex);
		if(null!= image.getOriginalFilename() &&  !image.getOriginalFilename().equals("") ){
			String imgname =  image.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("upload");  
		FileUtils.copyInputStreamToFile(image.getInputStream(), new File(path, image.getOriginalFilename())); 
		System.out.println(path);
		cosmetics.setCosmetics_img("/upload/"+imgname);
		}
		cosmetics.setCosmeticstype(type);
		gls.savecos(cosmetics);	
		redirectAttributes.addFlashAttribute("message", "更新商品成功");

		return "redirect:/gl/listcos";
		
	}
	@RequestMapping(value="getcos/{id}",method = RequestMethod.GET)
	public String getcos(@PathVariable("id") Long id,Model model,ServletRequest request){
		Cosmetics  cosmetics =  gls.getcos(id);
		model.addAttribute("cos", cosmetics);
		return "spzx/getcos";
		
	}
	@ModelAttribute("preloadCosmetics")
	public Cosmetics getTask2(@RequestParam(value = "cosmetics_id", required = false) Long id) {
		if (id != null) {
			return gls.getcos(id);
		}
		return null;
	}
	@RequestMapping(value="getmyorder")
	public String getmyorder(Model model){
		List<Map<String,String>> list = mpts.getmyorder();
		model.addAttribute("list", list);
		return "spzx/myorderlist";
		
	}
	@RequestMapping(value="updatemyorder/{id}",method= RequestMethod.GET)
	public String updatemyorder(@PathVariable("id") Long id,RedirectAttributes redirectAttributes,HttpServletRequest request){
		mpts.updatemyorder(id);
		redirectAttributes.addFlashAttribute("message", "发货成功");
		return "redirect:/gl/getmyorder";
		
	}
	@RequestMapping(value="getAdvice")
	public String getAdvice(@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request){
		Page<Advice>page = gls.getAdvice(pageNumber,PAGE_SIZE);
		model.addAttribute("page", page);
		return "spzx/advicelist";
	}
	@RequestMapping(value="deleteadvice/{id}",method = RequestMethod.GET)
	public String deleteadvice(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
		gls.deleteadvice(id);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/gl/getAdvice";
		
	}
	@RequestMapping(value="typetj")
	public String typetj(Model model){
		List<Map<String,String>> list =  mpts.typetj();
		model.addAttribute("list", list);
		return "spzx/typetj";
		
	}
	@RequestMapping(value="typetjxx/{id}",method = RequestMethod.GET)
	public String typetjxx(@PathVariable("id") Long id,Model model){
		List<Map<String,String>> list =  mpts.typetjxx(id);
		model.addAttribute("list", list);
		return "spzx/typetjxx";
		
	}
}
