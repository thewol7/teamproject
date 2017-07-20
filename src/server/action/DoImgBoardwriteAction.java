package server.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;

public class DoImgBoardwriteAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글쓰기 저장 동작
		String page_id = request.getParameter("page_id");
		request.setAttribute("page_id", page_id);
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("ckValue");

		/*------추출한 content에서 http 속성을 추출해서 저장하는 부분-------*/
		// 정규식은 http://로 시작해서 * 모든문자 (숫자/)로 끝나는 문자 패턴 http://.*([0-9a-zA-Z]/)
		Pattern patternImg = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Pattern patternHttp = Pattern.compile("http://.*([0-9a-zA-Z]/)");
		String getContent_Org = content;

		Matcher matchOrg = patternImg.matcher(getContent_Org);
		System.out.println("matchOrg: " + matchOrg);
		String pic_OrgUrl = null;
		if (matchOrg.find()) { // 이미지 태그를 찾았다면,,
			pic_OrgUrl = matchOrg.group(0); // 글 내용 중에 첫번째 이미지 태그를 뽑아옴.
		}
		System.out.println("pic OrgUrl 추출 완료");

		/* 여기까지 img태그 뽑아내고 아래는 http로 저장될 구문을 뽑아낸다 */
		String getContent_Save = pic_OrgUrl;
		Matcher matchSave = patternHttp.matcher(getContent_Save);
		String pic_SaveUrl = null;
		if (matchSave.find()) {
			pic_SaveUrl = matchSave.group(0);
		}
		System.out.println("pic_SaveUrl 추출 완료");
		System.out.println("page_id: " + page_id);
		System.out.println("title: " + title);
		System.out.println("content: " + content);
		System.out.println("pic_SaveUrl: " + pic_SaveUrl);
		/*---------------------------------------------------------------*/

		boolean insertPics = ServerDao.getInst().insertPics(request.getSession(), title, content, pic_SaveUrl);
		if (insertPics == true) {
			System.out.println("입력 정상");
			return new ActionForward("/board/imgboardlist.do?page_id=" + page_id);
			/*
			 * response.sendRedirect(request.getContextPath()+
			 * "/board/boardlist.jsp?page_id="+(String)request.getParameter(
			 * "page_id"));
			 */
		} else {
			System.out.println("입력 실패");
			return new ActionForward("/board/imgboardlist.do?page_id=" + page_id);
		}
	}

}
