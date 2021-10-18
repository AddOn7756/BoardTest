package model.message;

import java.sql.Date;

public class MessageVO {
	private int mnum;
	private String userid;
	private String title;
	private String content;
	private Date wdate;
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	@Override
	public String toString() {
		return "MessageVO [mnum=" + mnum + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", wdate=" + wdate + "]";
	}

	
}