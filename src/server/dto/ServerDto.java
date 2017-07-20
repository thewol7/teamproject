package server.dto;

public class ServerDto {
	private int user_id, cont_id, writer_id;
	private String id, name, regdate, content;

	public ServerDto() {
	}

	public ServerDto(int user_id, int cont_id, int writer_id, String id, String name, String regdate, String content) {
		super();
		this.user_id = user_id;
		this.cont_id = cont_id;
		this.writer_id = writer_id;
		this.id = id;
		this.name = name;
		this.regdate = regdate;
		this.content = content;
	}

	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

	public int getCont_id() {
		return cont_id;
	}

	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
