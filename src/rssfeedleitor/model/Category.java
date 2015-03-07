package rssfeedleitor.model;

import java.util.Calendar;
import java.util.List;

public class Category {

	private Integer id;
	private String title;
	private String description;
	private Calendar date;
	
	private List<Channel> channels;
	
	public Category(Integer id, String title, String description, Calendar date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
