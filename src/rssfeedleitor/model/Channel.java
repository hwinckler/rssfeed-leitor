package rssfeedleitor.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Channel {

	private Integer id;
	private String title;
	private String link;
	private Calendar lastSynchronize;
	private Boolean synchronize = Boolean.TRUE;
	
	private Category category;
	private List<Feed> feeds = new ArrayList<Feed>();
	
	public Channel(Category category, String title, String link, Calendar lastSynchronize) {
		super();
		this.category = category;
		this.title = title;
		this.link = link;
		this.lastSynchronize = lastSynchronize;
	}
	
	

	public Channel(String title, String link, Calendar lastSynchronize) {
		super();
		this.title = title;
		this.link = link;
		this.lastSynchronize = lastSynchronize;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
