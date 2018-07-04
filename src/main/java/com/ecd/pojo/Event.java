package com.ecd.pojo;

/**
 * 作为本系统的主体：事件
 * 
 * @author Administrator
 *
 */
public class Event {

	private String event_id;// 事件的唯一识别
	private String event_description;// 事件描述
	private String event_address;// 事件的发生地址
	private String event_time;// 事件发生的时间
	private String event_summary;// 事件的总结：交由执法人员解决
	private String event_person;// 事件的举报人信息
	private String event_logging_person;// 事件的录入者：完成者为环保人员
	private String event_logging_time;// 事件录入时间：完成者为环保人员
	private String event_finish_time;// 事件完成时间：：完成者为执法人员
	private String event_grade;// 事件的等级判定：完成者为环保人员
	private String event_finish_person;// 事件的执行人

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public String getEvent_address() {
		return event_address;
	}

	public void setEvent_address(String event_address) {
		this.event_address = event_address;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	public String getEvent_summary() {
		return event_summary;
	}

	public void setEvent_summary(String event_summary) {
		this.event_summary = event_summary;
	}

	public String getEvent_person() {
		return event_person;
	}

	public void setEvent_person(String event_person) {
		this.event_person = event_person;
	}

	public String getEvent_logging_person() {
		return event_logging_person;
	}

	public void setEvent_logging_person(String event_logging_person) {
		this.event_logging_person = event_logging_person;
	}

	public String getEvent_logging_time() {
		return event_logging_time;
	}

	public void setEvent_logging_time(String event_logging_time) {
		this.event_logging_time = event_logging_time;
	}

	public String getEvent_finish_time() {
		return event_finish_time;
	}

	public void setEvent_finish_time(String event_finish_time) {
		this.event_finish_time = event_finish_time;
	}

	public String getEvent_grade() {
		return event_grade;
	}

	public void setEvent_grade(String event_grade) {
		this.event_grade = event_grade;
	}

	public String getEvent_finish_person() {
		return event_finish_person;
	}

	public void setEvent_finish_person(String event_finish_person) {
		this.event_finish_person = event_finish_person;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", event_description=" + event_description + ", event_address="
				+ event_address + ", event_time=" + event_time + ", event_summary=" + event_summary + ", event_person="
				+ event_person + ", event_logging_person=" + event_logging_person + ", event_logging_time="
				+ event_logging_time + ", event_finish_time=" + event_finish_time + ", event_grade=" + event_grade
				+ ", event_finish_person=" + event_finish_person + "]";
	}

	public Event(String event_id, String event_description, String event_address, String event_time,
			String event_summary, String event_person, String event_logging_person, String event_logging_time,
			String event_finish_time, String event_grade, String event_finish_person) {
		super();
		this.event_id = event_id;
		this.event_description = event_description;
		this.event_address = event_address;
		this.event_time = event_time;
		this.event_summary = event_summary;
		this.event_person = event_person;
		this.event_logging_person = event_logging_person;
		this.event_logging_time = event_logging_time;
		this.event_finish_time = event_finish_time;
		this.event_grade = event_grade;
		this.event_finish_person = event_finish_person;
	}

	public Event() {
		super();
	}

}
