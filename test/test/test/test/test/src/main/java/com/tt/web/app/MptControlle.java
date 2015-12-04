package com.tt.web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.modules.mapper.JsonMapper;

import com.tt.entity.Advice;
import com.tt.entity.CosmeticType;
import com.tt.entity.Cosmetics;
import com.tt.entity.MyorderBen;
import com.tt.entity.ShoppingCar;
import com.tt.entity.User;
import com.tt.service.app.MptService;

@Controller
@RequestMapping("mpt")
public class MptControlle {	
	@Autowired
	private MptService mpts;
	private static JsonMapper mapper = JsonMapper.nonDefaultMapper();
	@RequestMapping("login")
	public void login(User user,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		User user1 = new User();
		user1 = mpts.getuser(user);
		if(user1==null || user1.getUsername()==null){
			
			out.write("-1");
		}else if(user1.getPassword().equals(user.getPassword())){
			String json =  mapper.toJson(user1);
			out.write(json);
		}else{
			out.write("-2");
		}
		out.close();
	} 
	
	@RequestMapping("zc")
	public void zc(User user,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			User user1 = new User();
			user1 = mpts.getuser(user);
			
			if(user1!=null){
				out.write("-3");
			}else{
				mpts.saveuser(user);
				out.write("1");
			}
			
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	@RequestMapping("querytype")
	public void querytype(HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<CosmeticType> list = mpts.getAll();
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	}
	@RequestMapping("queryct")
	public void queryCosmeticsbytype(Long typeid,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Map<String,String>> list = mpts.queryCosmeticsbytype(typeid);
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	}
	@RequestMapping("queryc")
	public void queryCosmetics(Long id,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		Cosmetics cos =  mpts.getCos(id);
		String json = mapper.toJson(cos); 
		out.write(json);
		out.close();
		
	}
	@RequestMapping("querycpp")
	public void querycospp(String name,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		System.out.println("121111111111111111111111111"+name);
		List<Map<String,String>> list = mpts.querycospp(name);
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	}
	@RequestMapping("queryzhuye")
	public void queryzhuye(String type,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Map<String,String>> list  = mpts.queryzhuye(type);
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	}
	@RequestMapping("querycosq")
	public void querycosq(HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Cosmetics> list = mpts.queryCos(); 
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	} 
	@RequestMapping("updatemm")
	public void updatemm(Long userid,String password,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.updatemm(userid,password);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();

		}finally{
			out.close();
		}
	}
	@RequestMapping("savecar")
	public void savecar(Long cosmetics_id,Integer buy_count,Integer comstics_count,Long user_id,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.savecar(cosmetics_id,buy_count,comstics_count,user_id);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	@RequestMapping("querycar")
	public void querycar(Long user_id,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Map<String,String>> list = mpts.querycar(user_id);
		String json = mapper.toJson(list); 
		out.write(json);
		out.close();
	}
	@RequestMapping("deletecar")
	public void deletecar(String shoppid,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.deletecar(shoppid);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
	} 
	@RequestMapping("deletecarsp")
	public void deletecarsp(String shoppid,String cosid,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.deletecarsp(shoppid,cosid);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	@RequestMapping("savedt")
	public void savedt(MyorderBen myorder,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.savedt(myorder);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	@RequestMapping("querydtall")
	public void querydtall(int user_id,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Map<String,String>> map  = mpts.querydtall(user_id);
		String json = mapper.toJson(map); 
		out.write(json);
		out.close();
	}
	@RequestMapping("queryzixun")
	public void queryzixun(Long type,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		List<Map<String,String>> map = mpts.queryzixun(type);
		String json = mapper.toJson(map); 
		out.write(json);
		out.close();
	}
	@RequestMapping("saveAdvice")
	public void saveAdvice(Advice advice,HttpServletResponse request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			mpts.saveadvice(advice);
			out.write("1");
		} catch (Exception e) {
			out.write("-1");
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

	
}
