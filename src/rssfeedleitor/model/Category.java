package rssfeedleitor.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Category {

	private Integer id;
	private String title;
	private Calendar date;
	
	private List<Channel> channels = new ArrayList<Channel>();
	
	public Category(String title, Calendar date) {
		super();
		this.title = title;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public List<Channel> getChannels() {
		return channels;
	}
	
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
}
