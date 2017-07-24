package server.img.dto;

public class ImgDto {
	private int user_id;
	private int cont_id;
	private String content_title;
	private String content_content;
	private String pic;
	private int view_count;
	private String cont_date;
	
	private int startRowNum; //시작 row 번호
	private int endRowNum; //끝 row 번호
	private int prevNum; //이전글의 글번호
	private int nextNum; //다음글의 글번호
	
	public ImgDto(){}

	public ImgDto(int user_id, int cont_id, String content_title, String content_content, String pic, int view_count,
			String cont_date, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.user_id = user_id;
		this.cont_id = cont_id;
		this.content_title = content_title;
		this.content_content = content_content;
		this.pic = pic;
		this.view_count = view_count;
		this.cont_date = cont_date;
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

	public String getContent_title() {
		return content_title;
	}

	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}

	public String getContent_content() {
		return content_content;
	}

	public void setContent_content(String content_content) {
		this.content_content = content_content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public String getCont_date() {
		return cont_date;
	}

	public void setCont_date(String cont_date) {
		this.cont_date = cont_date;
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
