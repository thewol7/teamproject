package server.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.comment.dto.CommentDto;
import server.mybatis.SqlMapConfig;

public class CommentDao {
	private static CommentDao dao;
	private static SqlSessionFactory factory;
	private CommentDao(){}
	//자신의 참조값을 리턴해주는 static 맴버 메소드 
	public static CommentDao getInstance(){
		if(dao==null){
			dao=new CommentDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	// 일반 게시판 댓글 ------------------------------------------------------------------------
	public void priInsert(CommentDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("Comment.priInsert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//덧글 목록을 리턴하는 메소드
	public List<CommentDto> priGetList(int ref_group){
		SqlSession session=factory.openSession();
		List<CommentDto> list=null;
		try{
			list=session.selectList("Comment.priGetList", ref_group);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	//새 덧글의 글번호(sequence) 값을 얻어내서 리턴해주는 메소드
	public int priGetSequence(){
		SqlSession session=factory.openSession();
		int num=0;
		try{
			num=session.selectOne("Comment.priGetSequence");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}
	
	// 이미지 게시판 댓글 ------------------------------------------------------------------------
	public void picInsert(CommentDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("Comment.picInsert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//덧글 목록을 리턴하는 메소드
	public List<CommentDto> picGetList(int ref_group){
		SqlSession session=factory.openSession();
		List<CommentDto> list=null;
		try{
			list=session.selectList("Comment.picGetList", ref_group);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	//새 덧글의 글번호(sequence) 값을 얻어내서 리턴해주는 메소드
	public int picGetSequence(){
		SqlSession session=factory.openSession();
		int num=0;
		try{
			num=session.selectOne("Comment.picGetSequence");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}
}







