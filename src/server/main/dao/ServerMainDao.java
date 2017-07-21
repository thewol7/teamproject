package server.main.dao;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import server.main.dto.ServerMainDto;
import server.mybatis.SqlMapConfig;

public class ServerMainDao {
	private static ServerMainDao dao;
	private static SqlSessionFactory factory;
	private ServerMainDao(){}
	
	public static ServerMainDao getInst(){
		if(dao==null){
			dao=new ServerMainDao();
			factory=SqlMapConfig.getSqlSession();
		}
		
		return dao;
	}
	
	public boolean idCheck(String id){
		SqlSession session=factory.openSession();
		int result=session.selectOne("main.idcheck", id);
		session.close();
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	
	public void signup(ServerMainDto dto){
		SqlSession session=factory.openSession(true);
		session.insert("main.signup", dto);
		session.close();
	}
	
	public int login(ServerMainDto dto){
		SqlSession session=factory.openSession();
		Object result=session.selectOne("main.login", dto);
		session.close();
		if(result!=null){
			return (int)result;
		}else{
			return 0;
		}
	}
	
	public ServerMainDto getInfo(int user_id){
		SqlSession session=factory.openSession();
		ServerMainDto dto=session.selectOne("main.getInfo", user_id);
		session.close();
		return dto;
	}
	
	public ServerMainDto getRandomPage(){
		SqlSession session=factory.openSession();
		List<ServerMainDto> users=session.selectList("main.getRandomPage");
		session.close();
		if(users!=null){
			Random ran=new Random();
			int result=ran.nextInt(users.size());
			return users.get(result);
		}else{
			return new ServerMainDto();
		}
	}
}
