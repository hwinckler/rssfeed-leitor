package rssfeedleitor.model;

import java.util.Calendar;
import java.util.List;

public class Channel {

	private Integer id;
	private String name;
	private String url;
	private Calendar date;
	private Calendar lastSynchronize;
	private Boolean synchronize = Boolean.TRUE;
	
	private Category category;
	private List<Feed> feeds;
	
	public Channel(String name, String url, Calendar date, Calendar lastSynchronize) {
		super();
		this.name = name;
		this.url = url;
		this.date = date;
		this.lastSynchronize = lastSynchronize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getLastSynchronize() {
		return lastSynchronize;
	}

	public void setLastSynchronize(Calendar lastSynchronize) {
		this.lastSynchronize = lastSynchronize;
	}

	public Boolean getSynchronize() {
		return synchronize;
	}

	public void setSynchronize(Boolean synchronize) {
		this.synchronize = synchronize;
	}
		
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Feed> getFeeds() {
		return feeds;
	}
	
	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
}
