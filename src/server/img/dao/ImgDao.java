package server.img.dao;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
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
		SqlSession session=factory.openSession(true);
		
		try{
			session.insert("img.insert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<ImgDto> getList(ImgDto dto){
		SqlSession session=factory.openSession(true);
		
		List<ImgDto> list=null;
		try{
			list=session.selectList("img.getList",dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public ImgDto getPicdetail(int cont_id){
		SqlSession session=factory.openSession(true);
		ImgDto dto=null;
		try{
			dto=session.selectOne("img.getPicdetail", cont_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return dto;
	}
	
	public void increaseViewCount(int cont_id){
		SqlSession session = factory.openSession(true);
		try{
			session.update("img.increaseViewCount", cont_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deletePics(int cont_id){
		SqlSession session=factory.openSession(true);
		try{
		session.delete("img.delete", cont_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		session.close();
		}
	}
	
	public void updatePics(ImgDto dto){
		SqlSession session=factory.openSession(true);
		try{
		session.update("img.update", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		session.close();
		}
	}
	
	//DB 에 저장된 게시글 전체의 갯수를 리턴해주는 메소드
	public int getCount(){
		SqlSession session=factory.openSession();
		int count=session.selectOne("img.getCount");
		session.close();
		return count;
	}
}
