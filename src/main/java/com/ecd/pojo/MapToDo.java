package com.ecd.pojo;

public class MapToDo {

	private String map2Do_event_id;
	private String map2Do_email;
	private String map2Do_name;
	private String map2Do_event_description;
	private String map2Do_event_address;
	private String map2Do_event_time;

	public String getMap2Do_event_id() {
		return map2Do_event_id;
	}

	public void setMap2Do_event_id(String map2Do_event_id) {
		this.map2Do_event_id = map2Do_event_id;
	}

	public String getMap2Do_name() {
		return map2Do_name;
	}

	public void setMap2Do_name(String map2Do_name) {
		this.map2Do_name = map2Do_name;
	}

	public String getMap2Do_event_description() {
		return map2Do_event_description;
	}

	public void setMap2Do_event_description(String map2Do_event_description) {
		this.map2Do_event_description = map2Do_event_description;
	}

	public String getMap2Do_event_address() {
		return map2Do_event_address;
	}

	public void setMap2Do_event_address(String map2Do_event_address) {
		this.map2Do_event_address = map2Do_event_address;
	}

	public String getMap2Do_event_time() {
		return map2Do_event_time;
	}

	public void setMap2Do_event_time(String map2Do_event_time) {
		this.map2Do_event_time = map2Do_event_time;
	}

	public String getMap2Do_email() {
		return map2Do_email;
	}

	public void setMap2Do_email(String map2Do_email) {
		this.map2Do_email = map2Do_email;
	}

	public MapToDo(String map2Do_event_id, String map2Do_email, String map2Do_name, String map2Do_event_description,
			String map2Do_event_address, String map2Do_event_time) {
		super();
		this.map2Do_event_id = map2Do_event_id;
		this.map2Do_email = map2Do_email;
		this.map2Do_name = map2Do_name;
		this.map2Do_event_description = map2Do_event_description;
		this.map2Do_event_address = map2Do_event_address;
		this.map2Do_event_time = map2Do_event_time;
	}

	public MapToDo() {
		super();
	}

	@Override
	public String toString() {
		return "MapToDo [map2Do_event_id=" + map2Do_event_id + ", map2Do_email=" + map2Do_email + ", map2Do_name="
				+ map2Do_name + ", map2Do_event_description=" + map2Do_event_description + ", map2Do_event_address="
				+ map2Do_event_address + ", map2Do_event_time=" + map2Do_event_time + "]";
	}

}
