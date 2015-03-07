package rssfeedleitor.model;

import java.util.Calendar;

public class Feed {
	
	private Integer id;
	private Integer guid;
	private String title;
	private String description;
	private Calendar pubDate;
	private String link;
	
	private Channel channel;
	
	public Feed(Integer guid, String title, String description,
			Calendar pubDate, String link) {
		super();
		this.guid = guid;
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link = link;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGuid() {
		return guid;
	}
	public void setGuid(Integer guid) {
		this.guid = guid;
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
	public Calendar getPubDate() {
		return pubDate;
	}
	public void setPubDate(Calendar pubDate) {
		this.pubDate = pubDate;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
