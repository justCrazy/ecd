package com.ecd.pojo;

/**
 * 本实体类为系统中的一系列公告
 * 
 * @author Administrator
 *
 */
public class Notice {

	private int notice_id;// 公告的唯一识别
	private String title;// 公告的标题
	private String content;// 公告的内容
	private String notice_person;// 公告的发布人
	private String time;

	public int getNotice_id() {
		return notice_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
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

	public String getNotice_person() {
		return notice_person;
	}

	public void setNotice_person(String notice_person) {
		this.notice_person = notice_person;
	}

	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", title=" + title + ", content=" + content + ", notice_person="
				+ notice_person + ", time=" + time + "]";
	}

	public Notice(int notice_id, String title, String content, String notice_person, String time) {
		super();
		this.notice_id = notice_id;
		this.title = title;
		this.content = content;
		this.notice_person = notice_person;
		this.time = time;
	}

	public Notice() {
		super();
	}

}
