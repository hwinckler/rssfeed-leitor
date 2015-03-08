package rssfeedleitor.reader;

import java.io.InputStream;
import java.util.Calendar;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public class RSSFeedParser implements RSSFeed{

	private static final Logger logger = LogManager.getLogger(RSSFeedParser.class);
	
	private XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	
	@Override
	public Channel parse(InputStream stream)throws RSSFeedParserException {
		
		Channel channel = null;
		XMLEventReader eventReader = null;
		boolean isFeedHeader = true;
		Calendar date = Calendar.getInstance();
		
		try{
			
			//channel = new Channel(null, "Teste do RSSFeedParser", "teste", Calendar.getInstance(), Calendar.getInstance());
			
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
			        	isFeedHeader = (isFeedHeader) ? false : isFeedHeader;
			        	
			        	channel = new Channel(title, link, date, date);
			        	
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
			            pubDate = eventReader.nextEvent().asCharacters().getData();
			            break;			            
			          }
					
				}
				else if (event.isEndElement()) {
		          if (event.asEndElement().getName().getLocalPart().equalsIgnoreCase("item")) {

		        	  Feed feed = new Feed(guid, title, pubDate, link);
		        	  channel.getFeeds().add(feed);
		        	  
		            event = eventReader.nextEvent();
		            continue;
		          }
				}
				
				System.out.println("> " + event);
				
			}
			
			
			
		}
		catch(Exception e){
			logger.error(e);
			
			throw new RSSFeedParserException(e);
		}
		finally{
			if(eventReader != null){
				try {
					eventReader.close();
				} catch (XMLStreamException e) {
					logger.error(e);
				}
			}
		}
		
		return channel;
	}
	
}
