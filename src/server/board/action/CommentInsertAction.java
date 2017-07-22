package server.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.CommentDao;
import server.board.dto.CommentDto;
import server.controller.Action;
import server.controller.ActionForward;

public class CommentInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파리미터로 전달되는 내용 읽어오기
		Object user_id = request.getSession().getAttribute("id");
		String writer=request.getParameter("writer");
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		String content=request.getParameter("content");
		//덧글 내에서의 그룹번호를 읽어온다. 
		//null 이면 원글에 대한 덧글이고 아니면 덧글에 대한 덧글이다.
		String comment_group=request.getParameter("comment_group");
		String board_id = request.getParameter("board_id");
		//저장할 덧글 번호를 미리 읽어온다.
		int seq=CommentDao.getInstance().priGetSequence();
		
		//새덧글 정보를 Dto 에 담는다. 일반게시판 id = 1, 이미지게시판id = 2
		if(board_id.equals("1")){
			CommentDto dto=new CommentDto();
			dto.setNum(seq);
			dto.setUser_id((int) user_id);
			dto.setWriter(writer);
			dto.setContent(content);
			dto.setRef_group(ref_group);
			if(comment_group==null){//원글에 대한 덧글인 경우
				//덧글의 그룹번호를 덧글의 글번호와 같게 설정한다.
				dto.setComment_group(seq);
			}else{//덧글의 덧글인 경우 
				//파라미터로 넘어온 덧글의 그룹번호를 넣어준다.
				dto.setComment_group(Integer.parseInt(comment_group));
			}
			//DB 에 저장하고			
			CommentDao.getInstance().priInsert(dto);
			System.out.println("db저장완료");
			
			//리다일렉트 하라고 응답한다.
			return new ActionForward("/views/board/boarddetail.do?cont_id="+ref_group, true);
		}else if(board_id.equals("2")){
			
		}
		return null;
		
	}
	
}









