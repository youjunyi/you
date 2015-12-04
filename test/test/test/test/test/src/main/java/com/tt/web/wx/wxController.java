//package com.tt.web.wx;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springside.modules.web.Servlets;
//
//import com.google.common.collect.Maps;
//import com.tt.entity.Jiejuefanan;
//import com.tt.entity.Shouji;
//import com.tt.entity.Wxliucheng;
//import com.tt.service.wx.WxService;
//
//@Controller
//@RequestMapping(value="/wx")
//public class wxController {
//	private static final int PAGE_SIZE = 10;
//	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
//	private static int K =1;
//	@Autowired
//	private WxService wxs;
//	static {
//		sortTypes.put("auto", "自动");
//		sortTypes.put("name", "名称");
//	}
//	@RequestMapping(value="save")
//	public ModelAndView shouli(){
//		System.out.println("sssssss");
//		ModelAndView mav = new ModelAndView("wx/sl");
//		 Date date = new Date();
//	      
//	        String number = String.format("%tY%<tm%<td%03d",date,K);
//	        K++;
//	        mav.addObject("bh",number);
//		return mav;
//	}
//	
//
//	@RequestMapping(value="sylist")
//	public ModelAndView sylist(ServletRequest request) throws ParseException{
//		ModelAndView mav = new ModelAndView("wx/sylist");
//		
//		Map<String,Object> map =  new HashMap<String, Object>();
//		map.put("name", request.getParameter("name"));
//		map.put("xlh", request.getParameter("xlh"));
//		map.put("imei", request.getParameter("imei"));
//		map.put("khdh", request.getParameter("khdh"));
//		map.put("jqlx", request.getParameter("jqlx"));
//		map.put("bxlx", request.getParameter("bxlx"));
//		map.put("bh", request.getParameter("bh"));
//		map.put("fwfbh", request.getParameter("fwfbh"));
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		if(null != request.getParameter("kssj") && !request.getParameter("kssj").equals("") ){
//			String kssj = request.getParameter("kssj").toString();
//			Date date = format.parse(kssj);
//			String dd = format1.format(date);
//			System.out.println(dd);
//			map.put("kssj", dd);
//
//		}
//		if(null != request.getParameter("jssj") && !request.getParameter("jssj").equals("") ){
//			String jssj = request.getParameter("jssj").toString();
//			Date date = format.parse(jssj);
//			String dd = format1.format(date);
//
//			map.put("jssj", dd);
//
//		}
//		System.out.println(map.toString());
//		List<Map<String,String>> list = wxs.querysywx(map);
//		mav.addObject("list",list);
//		return mav;
//		
//	}
//	
//	@RequestMapping(value="jufa")
//	public ModelAndView jufa(Long id){
//		Wxliucheng lc  = wxs.getlc(id);
//		 ModelAndView mav  = new ModelAndView("wx/jjfa");
//	
//		mav.addObject("lc",lc);
//		return mav;
//		
//	}
//	@RequestMapping(value="savejj")
//	public String savejj(Jiejuefanan jj, Long lcid,HttpServletResponse response ) throws IOException{
//	
//		wxs.save2(jj,lcid);
//
//		return "redirect:/wx/tz";	
//	}
//	@RequestMapping(value="quji")
//	public ModelAndView quji(Long id){
//		ModelAndView mav = new ModelAndView("wx/quji");
//		Wxliucheng lc  = wxs.getlc(id);
//		
//		mav.addObject("lc",lc);
//		return mav;	
//	}
//	@RequestMapping(value="xkkh")
//	public ModelAndView xkkh(Long id){
//		ModelAndView mav = new ModelAndView("wx/xkkh");
//		Shouji sj = wxs.getsj(id);
//		mav.addObject("sj",sj);
//		return mav;
//	}
//	@RequestMapping(value="ckxx")
//	public ModelAndView ckxx(Long id){
//		ModelAndView mav = new ModelAndView("wx/ckxx");
//		Wxliucheng lc  = wxs.getlc(id);
//		mav.addObject("lc",lc);
//		return mav;
//	}
//	@RequestMapping(value="qujiw")
//	public String qujiw(Long id,ServletRequest request){
//		String st = "false";
//		System.out.println("moguidebufa......."+request.getParameter("wcbz"));
//		try {
//			Wxliucheng lc  = wxs.getlc(id);
//			lc.setJssj(new Date());
//			lc.setBiaozhi("完成");
//			lc.setWcbz(request.getParameter("wcbz"));
//			wxs.save3(lc);
//			st="true";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return st;
//		
//	}
//	@RequestMapping(value="dayin")
//	public ModelAndView dayin(String bh){
//		ModelAndView mav = new ModelAndView("wx/print");
//		mav.addObject("bh",bh);
//		mav.addObject("date",new Date());
//		return mav;
//		
//	}
//	@RequestMapping(value="tz")
//	public ModelAndView tz(){
//		ModelAndView mav = new ModelAndView("wx/tz");
//		return mav;
//	}
//	@RequestMapping(value="delete")
//	public String delete(Long id,RedirectAttributes redirectAttributes){
//		wxs.delete(id);
//		redirectAttributes.addFlashAttribute("message", "删除成功");
//		return "redirect:/wx/sylist";
//	}
//}
