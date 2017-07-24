package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.dto.ServerDto;
import server.mybatis.SqlMapConfig;
import server.util.DbcpBean;

public class ServerDao {
	private static ServerDao dao;
	private static SqlSessionFactory factory;
	private ServerDao(){}
	
	public static ServerDao getInst(){
		if(dao==null){
			dao=new ServerDao();
			factory=SqlMapConfig.getSqlSession();
		}
		
		return dao;
	}
	
	public boolean idCheck(String id){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT * FROM tp_account WHERE id=?");
			pst.setString(1, id);
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
	
	//占쏙옙占쏙옙 占쏙옙占쏙옙: TRUE 占쏙옙占쏙옙, FALSE 占쏙옙占쏙옙
	public boolean createAccount(String id, String pwd, String name, String gender, String phone, String email){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT * FROM tp_account WHERE id=? AND pwd=? AND name=?");
			pst.setString(1, id);
			pst.setString(2, pwd);
			pst.setString(3, name);
			ca=pst.executeUpdate();
			
			if(ca<=0){
				pst.clearParameters();
				pst=null;
				pst=conn.prepareStatement("INSERT INTO tp_account VALUES(tp_account_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)");
				pst.setString(1, id);
				pst.setString(2, pwd);
				pst.setString(3, name);
				pst.setString(4, gender);
				pst.setString(5, phone);
				pst.setString(6, email);
				ca=pst.executeUpdate();
			}
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
	
	//占싸깍옙占쏙옙 占쌓쇽옙: 0 占쏙옙占쏙옙, 占쏙옙 占쏙옙 占쏙옙占쏙옙
	public int loginAction(String id, String pwd){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		int user_id=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT user_id FROM tp_account WHERE id=? AND pwd=?");
			pst.setString(1, id);
			pst.setString(2, pwd);
			rst=pst.executeQuery();
			while(rst.next()){
				user_id=rst.getInt("user_id");
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rst!=null)rst.close();
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(user_id!=0){
			return user_id;
		}else{
			return 0;
		}
	}
	
	public String getPageOwner(int page_id){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		String name="";
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT name FROM tp_account WHERE user_id=?");
			pst.setInt(1, page_id);
			rst=pst.executeQuery();
			while(rst.next()){
				name=rst.getString("name");
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(rst!=null)rst.close();
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		return name;
	}
	
	public double getMaxpage(int page_id){
		SqlSession session=factory.openSession();
		int count=session.selectOne("board.getCount",page_id);
		session.close();
		return count;
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
	
	public boolean insertPics(HttpSession session, String title, String content, String pic_url){ //, String pic_url
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag=0;
		
		try {
			conn = new DbcpBean().getConn();
			String sql = "INSERT INTO tp_picboard VALUES(?,tp_picboard_seq.NEXTVAL,?,?,?,DEFAULT,DEFAULT)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (Integer)session.getAttribute("id"));
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, pic_url);	
			flag=pstmt.executeUpdate();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<Map<String, Object>> getPicboard(int page_id, int initqty, int qty){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		ArrayList<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		int times=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT cont_id, content_title, content_content, pic, view_count, TO_CHAR(content_date, 'YYYY-MM-DD') AS condate FROM tp_picboard JOIN WHERE user_id=? ORDER BY content_date DESC");
			pst.setInt(1, page_id);
			rst=pst.executeQuery();
			while(rst.next()){
				if(times==qty)break;
				if(times>=initqty){
					Map<String, Object> tmp=new HashMap<String, Object>();
					tmp.put("cont_id", rst.getInt("cont_id"));
					tmp.put("content_title", rst.getString("content_title"));
					tmp.put("content_content", rst.getString("content_content"));
					tmp.put("pic", rst.getString("pic"));
					tmp.put("view_count", rst.getString("view_count"));
					tmp.put("content_date", rst.getString("condate"));
					data.add(tmp);
				}
				times++;
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
	
	public ArrayList<Map<String,Object>> getPicdetail(int cont_id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT content_title, content_content,pic,TO_CHAR(content_date, 'YYYY-MM-DD') AS condate FROM tp_picboard WHERE cont_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cont_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String,Object> tmp=new HashMap<String,Object>();
				tmp.put("content_title", rs.getString("content_title"));
				tmp.put("content_content", rs.getString("content_content"));
				tmp.put("pic_url", rs.getString("pic"));
				tmp.put("condate", rs.getString("condate"));
				data.add(tmp);
			}
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(data.size()>0){
			return data;
		}else{
			return null;
		}
	}
	
	public boolean updateimgviewcount(int cont_id){
		Connection conn=null;
		PreparedStatement pst=null;
		int ca=0;
	
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("UPDATE tp_picboard SET view_count=view_count+1 WHERE cont_id=?");
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
	
	public boolean deletePics(HttpSession session, int cont_id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try{
			conn=new DbcpBean().getConn();
			pstmt=conn.prepareStatement("DELETE FROM tp_picboard WHERE user_id=? AND cont_id=?");
			pstmt.setInt(1, (Integer)session.getAttribute("id"));
			pstmt.setInt(2, cont_id);
			flag=pstmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean updatePics(String content_title,String content_content, HttpSession session, int cont_id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try{
			conn=new DbcpBean().getConn();
			pstmt=conn.prepareStatement("UPDATE tp_picboard SET content_title=?, content_content=? WHERE user_id=? AND cont_id=?");
			pstmt.setString(1, content_title);
			pstmt.setString(2, content_content);
			pstmt.setInt(3, (Integer)session.getAttribute("id"));
			pstmt.setInt(4, cont_id);
			flag=pstmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	//for picboard
	public double getMaxpage2(int page_id){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		double count=0;
		
		try{
			conn=new DbcpBean().getConn();
			pst=conn.prepareStatement("SELECT count(*) AS count FROM tp_picboard WHERE user_id=?");
			pst.setInt(1, page_id);
			rst=pst.executeQuery();
			while(rst.next()){
				count=rst.getDouble("count");
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		return count;
	}
	
	public ArrayList<Map<String, Object>> getOtherMems(){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		ArrayList<Map<String, Object>> data=null;
		
		try{
			conn=new DbcpBean().getConn();
			data=new ArrayList<Map<String, Object>>();
			pst=conn.prepareStatement("SELECT user_id, name, gender, email, create_date FROM tp_account");
			rst=pst.executeQuery();
			while(rst.next()){
				Map<String, Object> tmp=new HashMap<String, Object>();
				tmp.put("user_id", rst.getInt("user_id"));
				tmp.put("name", rst.getString("name"));
				tmp.put("gender", rst.getString("gender"));
				tmp.put("email", rst.getString("email"));
				tmp.put("create_date", rst.getString("create_date"));
				data.add(tmp);
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null)pst.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		return data;
	}
	
	//占쏙옙占싹몌옙占쏙옙트
		public List<ServerDto> getlist(int page_id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			List<ServerDto> list = new ArrayList<>();
			try {
				conn = new DbcpBean().getConn();
				String sql = "SELECT v.User_id,v.Writer_id ,v.cont_id,a.NAME,v.CONTENT,TO_CHAR(v.CONTENT_DATE,'YYYY-MM-DD HH24:MI:SS') AS CONTENT_DATE FROM tp_visboard v JOIN tp_account a on(v.writer_id=a.user_id) WHERE v.user_id = ? ORDER BY CONTENT_DATE DESC";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, page_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					int user_id=rs.getInt("user_id");
					int writer_id=rs.getInt("writer_id");
					int cont_id =rs.getInt("cont_id");
					String name = rs.getString("name");
					String content= rs.getString("content");
					String content_date = rs.getString("content_date");
					ServerDto dto = new ServerDto();
					dto.setUser_id(user_id);
					dto.setWriter_id(writer_id);
					dto.setCont_id(cont_id);
					dto.setName(name);
					dto.setContent(content);
					dto.setRegdate(content_date);
					list.add(dto);
					
				}
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close();
					if (pstmt != null)pstmt.close();
					if (conn != null)conn.close();				
				} catch (Exception e) {}			
			}
			return list;
		}//list
		
		public List<ServerDto> getlist2(int page_id, int init, int qty){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			List<ServerDto> list = new ArrayList<>();
			int count=init;
			
			try {
				conn = new DbcpBean().getConn();
				String sql = "SELECT v.writer_id, a.NAME,v.CONTENT FROM tp_visboard v JOIN tp_account a on(v.writer_id=a.user_id) WHERE v.user_id = ? ORDER BY CONTENT_DATE DESC";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, page_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					if(count==qty){
						break;
					}
					int writer_id=rs.getInt("writer_id");
					String name = rs.getString("name");
					String content= rs.getString("content");
					ServerDto dto = new ServerDto();
					dto.setWriter_id(writer_id);
					dto.setName(name);
					dto.setContent(content);
					list.add(dto);
					count++;
				}
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close();
					if (pstmt != null)pstmt.close();
					if (conn != null)conn.close();				
				} catch (Exception e) {}			
			}
			return list;
		}
		
		//占쏙옙占쏙옙 占쏙옙占쏙옙歐占�
		public boolean insert(ServerDto dto){
			Connection conn = null;
			PreparedStatement pstmt = null;
			int flag = 0;
			try {
				conn = new DbcpBean().getConn();
				String sql = "INSERT INTO tp_visboard (USER_ID,writer_id,CONT_ID,CONTENT,content_date) VALUES(?,?,tp_visboard_seq.NEXTVAL,?,SYSDATE)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getUser_id());
				pstmt.setInt(2, dto.getWriter_id());
				pstmt.setString(3, dto.getContent());
				flag = pstmt.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}

			}
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		}//insert
			
		//id 占쏙옙 占쌨아쇽옙 회占쏙옙占쌓깍옙占쏙옙占쏙옙dto占쏙옙占싹받깍옙 > 占싱몌옙占쏙옙占�
		public ServerDto getWriterName(int writer_id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ServerDto dto = null;
			try {
				conn = new DbcpBean().getConn();
				String sql = "SELECT name FROM tp_visboard v join tp_account a on(v.writer_id=a.user_id) WHERE writer_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, writer_id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
				//String id = rs.getString("id");
				String name = rs.getString("name");
				//int cont_id = rs.getInt("cont_id");
				dto= new ServerDto();
				//dto.setId(id);
				dto.setName(name);
				//dto.setCont_id(cont_id);
				}
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
			return dto;
		}//getWriterName
		
		public ServerDto getWriterName2(HttpSession session){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ServerDto dto = null;
			try {
				conn = new DbcpBean().getConn();
				String sql = "SELECT name FROM tp_account WHERE user_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (Integer)session.getAttribute("id"));
				rs = pstmt.executeQuery();
				while (rs.next()) {
				//String id = rs.getString("id");
				String name = rs.getString("name");
				//int cont_id = rs.getInt("cont_id");
				dto= new ServerDto();
				//dto.setId(id);
				dto.setName(name);
				//dto.setCont_id(cont_id);
				}
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
			return dto;
		}
		
		//id 占쏙옙 占쌨아쇽옙 회占쏙옙占쌓깍옙占쏙옙占쏙옙dto占쏙옙占싹받깍옙 > 占싱몌옙占쏙옙占�
			public ServerDto getPageName(int page_id){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ServerDto dto = null;
				try {
					conn = new DbcpBean().getConn();
					String sql = "SELECT NAME FROM TP_ACCOUNT WHERE USER_ID = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, page_id);
					rs = pstmt.executeQuery();
					while (rs.next()) {
					//String id = rs.getString("id");
					String name = rs.getString("name");
					//int cont_id = rs.getInt("cont_id");
					dto= new ServerDto();
					//dto.setId(id);
					dto.setName(name);
					//dto.setCont_id(cont_id);
					}
				} catch (Exception se) {
					se.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e) {
					}
				}
				return dto;
			}//getWriterName
		
		
		public boolean visBoDel(int cont_id,HttpSession httpsession){
			Connection conn = null;
			PreparedStatement pstmt = null;
			int flag = 0;
			try {
				conn = new DbcpBean().getConn();
				String sql = "DELETE FROM TP_VISBOARD WHERE cont_id = ? and writer_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cont_id);
				pstmt.setInt(2, (Integer)httpsession.getAttribute("id"));
				flag = pstmt.executeUpdate();
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}

			}
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		}
}
