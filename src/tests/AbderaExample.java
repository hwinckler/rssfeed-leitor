package tests;

import java.net.URL;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;



public class AbderaExample {

	public static void main(String[] args)throws Exception {
		
		Abdera abdera = new Abdera();
		Parser parser = abdera.getParser();
		             
		URL url = new URL("http://intertwingly.net/blog/index.atom");
		Document<Feed> doc = parser.parse(url.openStream(),url.toString());
		Feed feed = doc.getRoot();
		System.out.println(feed.getTitle());
		for (Entry entry : feed.getEntries()) {
		  System.out.println("\t" + entry.getTitle());
		}
		System.out.println (feed.getAuthor());

	}

}
