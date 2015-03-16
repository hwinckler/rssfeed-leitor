package rssfeedleitor.model;

import java.util.Date;

public class Feed {
	
	private Integer id;
	private Integer guid;
	private String title;
	private Date pubDate;
	private String link;
	
	private Channel channel;
	
	public Feed() {
	}
	
	public Feed(Channel channel, Integer guid, String title, Date pubDate, String link) {
		super();
		this.guid = guid;
		this.title = title;
		this.pubDate = pubDate;
		this.link = link;
		this.channel = channel;
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
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
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
