package rssfeedleitor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Category {

	public final static String DEFAULT = "Default";
	public final static Integer DEFAULT_ID = 1;
	
	private Integer id;
	private String title;
	private Date date;
	
	private Integer unread;
	
	private List<Channel> channels = new ArrayList<Channel>();
	
	public Category() {
	}

	public Category(Integer id){
		this.id = id;
	}
	
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
	
	public static Category newDefault(){
		return new Category(Category.DEFAULT, new Date());
	}
	
	public Integer getUnread() {
		return unread;
	}
	
	public void setUnread(Integer unread) {
		this.unread = unread;
	}
	
}
