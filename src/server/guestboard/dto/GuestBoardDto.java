package server.guestboard.dto;

public class GuestBoardDto {
	private int user_id, cont_id, writer_id;
	private String id, name, content_date, content;
	public GuestBoardDto(){}
	public GuestBoardDto(int user_id, int cont_id, int writer_id, String id, String name, String content_date,
			String content) {
		super();
		this.user_id = user_id;
		this.cont_id = cont_id;
		this.writer_id = writer_id;
		this.id = id;
		this.name = name;
		this.content_date = content_date;
		this.content = content;
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
	public String getcontent_date() {
		return content_date;
	}
	public void setcontent_date(String content_date) {
		this.content_date = content_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
