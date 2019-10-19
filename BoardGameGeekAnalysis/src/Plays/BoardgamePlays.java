package Plays;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			if (checkForParam(args, "-game") != null) {
				url += "&id=" + checkForParam(args, "-game");
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
	        List<Play> lovecraftPlays = new ArrayList<Play>();
	        lovecraftPlays = playsHandler.getPlays();
	        
	        List<Player> kris = new ArrayList<>();
	        List<Player> jon = new ArrayList<>();
	        List<Player> phil = new ArrayList<>();
	        
	        for (Play play : lovecraftPlays) {
	        	List<Player> players = play.getPlayers();
	        	for (Player player : players) {
	        		if (player.getName().equals("Kyzaa"))
	        			kris.add(player);
	        		else if (player.getName().equals("Jonas"))
	        			jon.add(player);
	        		else if (player.getName().equals("Philipp"))
	        			phil.add(player);
	        	}    	
	        }

    		int wins = 0;
    		int pointsSane = 0;
    		int pointsInsane = 0;
        	for (Player player : kris) {
        		if (player.getWin())
        			wins++;
        		String score = player.getScore();
        		int firstPart = Integer.valueOf(score.substring(0, 1));
        		int secondPart = 0;
        		if (score.length() > 1)
        			secondPart = Integer.valueOf(score.substring(2, 3));
        		if (player.getWin()) {
        			if (firstPart == 5) {
        				// TODO
        			}
        			else if (firstPart == 2) {
        				pointsSane += firstPart;
        				pointsInsane += secondPart;
        			}
        			else {
        				pointsInsane += firstPart;
        				pointsInsane += secondPart;
        			}
        		} else {
        			if (firstPart == 2) {
        				pointsInsane += firstPart;
        				pointsSane += secondPart;
        			}
        		}
        			
        	}
        	System.out.println("Kris has won " + wins + " games of Lovecraft Letter");
        	System.out.println("He scored " + pointsSane + " sane points and " + pointsInsane + " insane Points");
//	        List<Play> sevenWonders = new ArrayList<Play>();
//	        for (Entry<String, Integer> entry : playsHandler.getPlays().entrySet()) {
//	        	Play p = (Play) entry; 
//	        	if (p.getName().equals("7 Wonders")) {
//	        		sevenWonders.add(p);
//	        	}
//	        }
//	        for (Play play : sevenWonders) {
//	        	for (Player player : play.getPlayers()) {
//	        		player.getColor();
//	        	}
//	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String checkForParam(String[] args, String param) {
		List<String> argsList = new ArrayList<>(Arrays.asList(args));
		int idx = argsList.indexOf(param);
		if (idx > -1)
			return argsList.get(idx + 1);
		return null;
	}

}
