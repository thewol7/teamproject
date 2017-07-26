package server.comment.dto;

/*
 *  덧글 하나의 정보를 담을 Dto 
 */
public class CommentDto {
	private int num; // 글번호
	private int user_id; // ${id}
	private String writer; // ${info.name}
	private String content;
	private int ref_group; // 덧글의 그룹 번호
	private int comment_group; // 덧글 내에서의 그룹
	private String regdate;
	private String profile_img;

	// 생성자
	public CommentDto() {
	}

	public CommentDto(int num, int user_id, String writer, String content, int ref_group, int comment_group,
			String regdate, String profile_img) {
		super();
		this.num = num;
		this.user_id = user_id;
		this.writer = writer;
		this.content = content;
		this.ref_group = ref_group;
		this.comment_group = comment_group;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public int getComment_group() {
		return comment_group;
	}

	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
}
