package com.ecd.pojo;

public class VO {

	private Person person;
	private Event event;
	private Notice notice;
	
	public Person getPerson() {
		return person;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	public VO(Person person, Event event, Notice notice) {
		super();
		this.person = person;
		this.event = event;
		this.notice = notice;
	}
	@Override
	public String toString() {
		return "VO [person=" + person + ", event=" + event + ", notice=" + notice + "]";
	}
	public VO() {
		super();
	}
	
}
