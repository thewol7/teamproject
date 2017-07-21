package server.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.board.dto.PriboardDto;
import server.mybatis.SqlMapConfig;
import server.util.DbcpBean;

public class PriboardDao {
	private static PriboardDao dao;
	private static SqlSessionFactory factory;
	private PriboardDao(){}
	
	public static PriboardDao getInst(){
		if(dao==null){
			dao=new PriboardDao();
			factory=SqlMapConfig.getSqlSession();
		}
		
		return dao;
	}
	public double getMaxpage(int page_id){
		SqlSession session=factory.openSession();
		int count=0;
		try{
			count=session.selectOne("board.getCount",page_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}
	
	public String getPageOwner(int page_id){
		SqlSession session=factory.openSession();
		String name=null;
		try{
			name=session.selectOne("board.getPageOwner", page_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
			return name;
	}
	public List<PriboardDto> getPriboard(int page_id, int initqty, int qty){
		SqlSession session=factory.openSession();
		List<PriboardDto> data=null;
		try{
			data=session.selectList("board.getList",page_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
			return data;
	}
	
	//priboard �� �ۼ�: TRUE ����, FALSE ����
	public void writePriboard(PriboardDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("board.write", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deletePriboard(PriboardDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.delete("board.delete", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	public void updatePriboard(PriboardDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.update("board.update", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public PriboardDto getPridetail(PriboardDto dto){
		SqlSession session=factory.openSession();
		PriboardDto data=null;
		try{
			data=session.selectOne("board.getPriDetail", dto); 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return data;
	}
	
	public void updateviewcount(int cont_id){
		SqlSession session=factory.openSession(true);
		try{
			session.update("board.upviewCount", cont_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
