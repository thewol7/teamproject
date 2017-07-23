package server.guestboard.dto;

public class GuestBoardDto {
	private int user_id, cont_id, writer_id;
	private String id, name, content_date, content;
	private int startRowNum; //시작 row 번호
	private int endRowNum; //끝 row 번호
	private int prevNum; //이전글의 글번호
	private int nextNum; //다음글의 글번호
	public GuestBoardDto(){}
	public GuestBoardDto(int user_id, int cont_id, int writer_id, String id, String name, String content_date,
			String content, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.user_id = user_id;
		this.cont_id = cont_id;
		this.writer_id = writer_id;
		this.id = id;
		this.name = name;
		this.content_date = content_date;
		this.content = content;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCont_id() {
		return cont_id;
	}
	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}
	public int getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent_date() {
		return content_date;
	}
	public void setContent_date(String content_date) {
		this.content_date = content_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getPrevNum() {
		return prevNum;
	}
	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}
	public int getNextNum() {
		return nextNum;
	}
	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
	
	
}
