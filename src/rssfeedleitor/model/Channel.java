package rssfeedleitor.model;

import java.util.Calendar;

public class Channel {

	public String name;
	public String url;
	public Calendar date;
	public Calendar lastSynchronize;
	
	public Channel(String name, String url, Calendar date, Calendar lastSynchronize) {
		super();
		this.name = name;
		this.url = url;
		this.date = date;
		this.lastSynchronize = lastSynchronize;
	}
	
	
	
}
