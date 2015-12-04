//package com.tt.web.buizhang;
//
//import java.util.Map;
//
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.google.common.collect.Maps;
//import com.tt.entity.Liucheng;
//import com.tt.service.zhekou.LiuchengService;
//import com.tt.service.zhekou.ShangpinService;
//
//@Controller
//@RequestMapping(value="/duizhang")
//public class DuizhangControlle {
//	@Autowired
//	private ShangpinService sps;
//	@Autowired
//	private LiuchengService lcs;
//	
//	@RequestMapping(value="update/{id}",method = RequestMethod.GET)
//	public String update(@PathVariable("id") Long id,  RedirectAttributes redirectAttributes){
//		
//	Liucheng liucheng =	lcs.getLiuchengno(id);
//		liucheng.setZt(2);
//		lcs.save(liucheng);
//		redirectAttributes.addFlashAttribute("message", "对账成功");
//		return "redirect:/chushou/list";
//		
//	}
//}
