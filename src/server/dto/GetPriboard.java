package server.dto;

public class GetPriboard {
	private String owner;
	private String title;
	private String content;
	private int num;
	
	public GetPriboard(String owner, String title, String content, int num) {
		super();
		this.owner = owner;
		this.title = title;
		this.content = content;
		this.num = num;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
