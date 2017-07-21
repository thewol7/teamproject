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
	public boolean writePriboard(HttpSession session, String content_title, String content_content){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("INSERT INTO tp_priboard VALUES(?, tp_priboard_seq.NEXTVAL, ?, ?, DEFAULT, DEFAULT)");
			pst.setInt(1, (Integer)session.getAttribute("id"));
			pst.setString(2, content_title);
			pst.setString(3, content_content);
			ca=pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(ca>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean deletePriboard(HttpSession session, int cont_id){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("DELETE FROM tp_priboard WHERE user_id=? AND cont_id=?");
			pst.setInt(1, (Integer)session.getAttribute("id"));
			pst.setInt(2, cont_id);
			ca=pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(ca>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updatePriboard(HttpSession session, int cont_id, String content_title, String content_content){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("UPDATE tp_priboard SET content_title=?, content_content=? WHERE user_id=? AND cont_id=?");
			pst.setString(1, content_title);
			pst.setString(2, content_content);
			pst.setInt(3, (Integer)session.getAttribute("id"));
			pst.setInt(4, cont_id);
			ca=pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(ca>0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getRandomPage(){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		ArrayList<Integer> pages=null;
		int page_id=0;
		
		try{
			conn=new DbcpBean().getConn();
			pages=new ArrayList<Integer>();
			pst=conn.prepareStatement("SELECT user_id FROM tp_account");
			rst=pst.executeQuery();
			while(rst.next()){
				pages.add(rst.getInt("user_id"));
			}
			Random ran=new Random();
			page_id=pages.get(ran.nextInt(pages.size()));
		}catch(Exception e){
			
		}finally{
			try{
				if(rst!=null)rst.close();
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		return page_id;
	}
	
	public ArrayList<Map<String, Object>> getPridetail(int cont_id){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		ArrayList<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT  content_title, content_content,"
					+ " TO_CHAR(content_date, 'YYYY-MM-DD') AS condate FROM tp_priboard WHERE cont_id=?");
			pst.setInt(1, cont_id);
			rst=pst.executeQuery();
			if(rst.next()){
				Map<String, Object> tmp=new HashMap<String, Object>();
				tmp.put("content_title", rst.getString("content_title"));
				tmp.put("content_content", rst.getString("content_content"));
				tmp.put("content_date", rst.getString("condate"));
				data.add(tmp);
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rst!=null)rst.close();
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		if(data.size()>0){
			return data;
		}else{
			return null;
		}
		
	}
	
	public boolean updateviewcount(int cont_id){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
	
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("UPDATE tp_priboard SET view_count=view_count+1 WHERE cont_id=?");
			pst.setInt(1, cont_id);
			ca=pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(ca>0){
			return true;
		}else{
			return false;
		}
	}
}
