package Plays;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

public class BoardgamePlays {
	
	private static String url = "https://api.geekdo.com/xmlapi2/plays?username=crisscross1197&id=18103";
	private static boolean useLocalFile = true;

	public static void main(String[] args) {
		
		try {
			File inputFile = null;
//			File inputFile = new File("D:\\development\\BGG\\tienLenPlays.xml");
			if (useLocalFile)
				inputFile = new File("/Users/kristian/OneDrive/Studium/BGG/TienLen/tienLenPlays.xml");
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        TienLenPlaysHandler playsHandler = new TienLenPlaysHandler();
	        if (inputFile != null) {
	        	saxParser.parse(inputFile, playsHandler);
	        } else {
	        	saxParser.parse(new InputSource(new URL(url).openStream()), playsHandler);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
