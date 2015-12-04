//package com.tt.web.chaxun;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//import java.util.List;
//
//import javax.servlet.ServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springside.modules.web.Servlets;
//
//import com.google.common.collect.Maps;
//import com.tt.entity.Fengcheng;
//import com.tt.entity.Liucheng;
//import com.tt.service.zhekou.FengchengService;
//import com.tt.service.zhekou.LiuchengService;
//
//@Controller
//@RequestMapping(value="/zhongtongji")
//public class ZhongtongjiController {
//	
//	@Autowired
//	private LiuchengService lcs;
//	@Autowired
//	private FengchengService fcs;
//	private static final int PAGE_SIZE = 10;
//	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
//	static {
//		sortTypes.put("auto", "自动");
//		sortTypes.put("czsj", "时间");
//	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String  List(@RequestParam(value="sortType",defaultValue="auto") String sortType,
//			@RequestParam(value="page",defaultValue="1")int pageNumber,Model model,ServletRequest request ) throws ParseException{
//		
//		System.out.println("ni shi  shui");
//		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//			System.out.println("map"+searchParams.toString());
//			
//			System.out.println("map"+searchParams.toString());
//
//		//Long userId = getCurrentUserId();
//			Integer type =1;
//			Integer zt = 2;
//			Integer lx = 2;
//		List<Liucheng> liucheng = lcs.getLiuchengall(type,searchParams,zt);
//		Fengcheng fengcheng = fcs.getFengchenglx(lx);
//		model.addAttribute("liucheng", liucheng);
//		model.addAttribute("fengcheng",fengcheng);
//		model.addAttribute("sortType", sortType);
//		model.addAttribute("sortTypes", sortTypes);
//		// 将搜索条件编码成字符串，用于排序，分页的URL
//		model.addAttribute("searchParams", searchParams);
//		System.out.println("map"+searchParams.toString());
//
//		
//		return "chaxun/ztjList";
//		
//	} 
//}
