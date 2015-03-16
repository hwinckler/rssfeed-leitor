package rssfeedleitor.reader;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public class RSSFeedParser implements RSSFeed{

	private static final Logger logger = LoggerFactory.getLogger(RSSFeedParser.class);

	private XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);

	@Override
	public Channel parse(InputStream stream)throws RSSFeedParserException {

		Channel channel = null;
		XMLEventReader eventReader = null;
		boolean isFeedHeader = true;

		try{

			eventReader = inputFactory.createXMLEventReader(stream);

			String title = "";
			String link = "";
			Integer guid = 0;
			Calendar pubDate = null;

			while (eventReader.hasNext()) {
				
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					String localPart = event.asStartElement().getName().getLocalPart();

					switch (localPart.toLowerCase()) {
					case "item":
						if(isFeedHeader){
							channel = new Channel(title, link, new Date());
							isFeedHeader = false;
						}
						event = eventReader.nextEvent();
						break;
					case "title":
						title = eventReader.nextEvent().asCharacters().getData();
						break;
					case "link":
						link = eventReader.nextEvent().asCharacters().getData();
						break;
					case "guid":
						guid = Integer.valueOf(eventReader.nextEvent().asCharacters().getData());
						break;	
					case "pubdate":
						pubDate = Calendar.getInstance();
						pubDate.setTime(sdf.parse(eventReader.nextEvent().asCharacters().getData()));
						break;			            
					}

				}
				else if (event.isEndElement()) {
					
					if (event.asEndElement().getName().getLocalPart().equalsIgnoreCase("item")) {

						Feed feed = new Feed(channel, guid, title, pubDate.getTime(), link);
						channel.getFeeds().add(feed);

						event = eventReader.nextEvent();
						continue;
					}
				}
			}
		}
		catch(Exception e){
			logger.error("error", e);

			throw new RSSFeedParserException(e);
		}
		finally{
			if(eventReader != null){
				try {
					eventReader.close();
				} catch (XMLStreamException e) {
					logger.error("error", e);
				}
			}
		}

		return channel;
	}

}
