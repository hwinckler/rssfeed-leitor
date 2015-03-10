package rssfeedleitor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Category {

	private Integer id;
	private String title;
	private Date date;
	
	private List<Channel> channels = new ArrayList<Channel>();
	
	public Category(String title, Date date) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Channel> getChannels() {
		return channels;
	}
	
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
}
