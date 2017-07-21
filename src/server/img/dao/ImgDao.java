package server.img.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSessionFactory;

import server.mybatis.SqlMapConfig;

public class ImgDao {
	private static ImgDao dao;
	private static SqlSessionFactory factory;
	private ImgDao(){}
	
	public static ImgDao getInst(){
		if(dao==null){
			dao=new ImgDao();
			factory=SqlMapConfig.getSqlSession();
		}
		
		return dao;
	}
	
	public boolean insertPics(HttpSession session, String title, String content, String pic_url){ //, String pic_url
		return false;
	}
	
	public ArrayList<Map<String, Object>> getPicboard(int page_id, int initqty, int qty){
		return null;
	}
	
	public ArrayList<Map<String,Object>> getPicdetail(int cont_id){
		return null;
	}
	
	public boolean updateimgviewcount(int cont_id){
		return false;
	}
	
	public boolean deletePics(HttpSession session, int cont_id){
		return false;
	}

	//for picboard
	public double getMaxpage2(int page_id){
		return 0;
	}
}
