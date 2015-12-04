package com.tt.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tt.entity.MyorderBen;
import com.tt.entity.ShoppingCar;

@MyBatisRepository
public interface WxBatis {

	List<Map<String, String>> list(Long userid);

	List<Map<String, String>> querysywx(Map<String, Object> map);

	List<Map<String, String>> queryCosmeticsbytype(Long typeid);

//	List<Map<String, String>> querycospp(String name);
	List<Map<String, String>> querycospp(@Param(value="name")String name);

	List<Map<String, String>> queryzhuye(String type);

	void updatemm(@Param(value="userid")Long userid, @Param(value="password")String password);

	void savecar(@Param(value="cosmetics_id")Long cosmetics_id, @Param(value="buy_count")Integer buy_count, @Param(value="comstics_count")Integer comstics_count,
			@Param(value="user_id")Long user_id);

	Map<String, Object> querycar(Long user_id);

	void savecarsho(@Param(value="cosmetics_id")Long cosmetics_id, @Param(value="string")Integer string, @Param(value="buy_count")Integer buy_count, @Param(value="comstics_count")Integer comstics_count);

	List<Map<String, String>> querycarall(Long user_id);

	void deletecar(String shoppid);

	void deletecarsp(@Param(value="shoppid")String shoppid, @Param(value="cosid")String cosid);

	void savedt(MyorderBen myorder);

	void updateshoopcar(int cosmetics_id);

	List<Map<String, String>> querydtall(int user_id);

	List<Map<String, String>> queryzixun(@Param(value="type")Long type);

	List<Map<String, String>> getmyorder();

	void updatemyorder(@Param(value="id")Long id);

	List<Map<String, String>> typetj();

	List<Map<String, String>> typetjxx(@Param(value="id")Long id);

}
