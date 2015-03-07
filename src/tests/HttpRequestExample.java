package tests;

import com.github.kevinsawicki.http.HttpRequest;

public class HttpRequestExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String response = HttpRequest.get("http://www.guj.com.br/noticias/rss")
		        .accept("application/xml")
		        .body();
		System.out.println("Response was: " + response);
		
	}

}
