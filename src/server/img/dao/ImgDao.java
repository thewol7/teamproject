package server.img.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.img.dto.ImgDto;
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
	
	public void insertPics(ImgDto dto){
		SqlSession session=factory.openSession();
		
		try{
			session.insert("img.insert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<ImgDto> getList(){
		SqlSession session=factory.openSession();
		
		List<ImgDto> list=null;
		try{
			list=session.selectList("img.getList");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public List<ImgDto> getPicdetail(int cont_id){
		return null;
	}
	
	public boolean updateimgviewcount(int cont_id){
		return false;
	}
	
	public boolean deletePics(int cont_id){
		return false;
	}

}
