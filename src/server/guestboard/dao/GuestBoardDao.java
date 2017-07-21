package server.guestboard.dao;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.guestboard.dto.GuestBoardDto;
import server.mybatis.SqlMapConfig;


public class GuestBoardDao {
	private static GuestBoardDao dao;
	private static SqlSessionFactory factory;
	private GuestBoardDao(){}
	public static GuestBoardDao getInstance(){
		if(dao == null){
			dao = new GuestBoardDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//방명록 리스트를 불러오는 메소드
	public List<GuestBoardDto> getList(int page_id){
		SqlSession session = factory.openSession();
		List<GuestBoardDto> list = session.selectList("guestboard.getList",page_id);
		session.close();
		return list;
	}
	//해당페이지주인의 이름을 가져오는 메소드
	
	public GuestBoardDto getUserName(int page_id){
		SqlSession session = factory.openSession();
		GuestBoardDto dto = session.selectOne("guestboard.getUserName",page_id);
		session.close();
		return dto;
	}
	//방명록을 남기는 작성자의 이름을 가져오는 메소드
	
	public GuestBoardDto getWriterName(int session_id){
		SqlSession session = factory.openSession();
		GuestBoardDto dto =session.selectOne("guestboard.getWriterName",session_id);
		session.close();
		return dto;
	}
	
	//방명록을 남기는 메소드(insert)
	
	public void insert(GuestBoardDto dto){
		SqlSession session = factory.openSession(true);
		try{
			session.insert("guestboard.insert",dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		session.close();
		
	}
}
