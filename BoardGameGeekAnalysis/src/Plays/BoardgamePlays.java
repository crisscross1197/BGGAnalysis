package Plays;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

public class BoardgamePlays {
	
	private static String url = "https://api.geekdo.com/xmlapi2/plays?username=crisscross1197";
	private static boolean useLocalFile = false;
	private static boolean onlyThisYear = false;

	public static void main(String[] args) {
		
		try {
			File inputFile = null;
//			File inputFile = new File("D:\\development\\BGG\\tienLenPlays.xml");
			if (useLocalFile) {
				inputFile = new File("/Users/kristian/OneDrive/Studium/BGG/TienLen/tienLenPlays.xml");
			}
			if (onlyThisYear) {
				url = url + "&mindate=2019-01-01";
			}
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
//	        TienLenPlaysHandler playsHandler = new TienLenPlaysHandler();
	        PlaysHandler playsHandler = new PlaysHandler();
	        for (int i = 1; i < 5; i++) { //TODO: Flexible depending on number of games
	        	url = url + "&page=" + i;
		        if (inputFile != null) {
		        	saxParser.parse(inputFile, playsHandler);
		        } else {
		        	saxParser.parse(new InputSource(new URL(url).openStream()), playsHandler);
		        }	
			}
	        List<Play> sevenWonders = new ArrayList<Play>();
	        for (Entry<String, Integer> entry : playsHandler.getPlays().entrySet()) {
	        	Play p = (Play) entry; 
	        	if (p.getName().equals("7 Wonders")) {
	        		sevenWonders.add(p);
	        	}
	        }
	        for (Play play : sevenWonders) {
	        	for (Player player : play.getPlayers()) {
	        		player.getColor();
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
