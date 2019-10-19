package Plays;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PlaysHandler extends DefaultHandler {
	
	HashMap<String, Integer> plays = new HashMap<String, Integer>();
	public HashMap<String, Integer> getPlays() {
		return plays;
	}

	DateFormat format = new SimpleDateFormat("dd.mm.yyyy", Locale.GERMAN);
	private String game;
	private Play play;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("plays")) {
			System.out.println("There are " + attributes.getValue("total") + " games recorded up to now!");
		} else if (qName.equalsIgnoreCase("play")) {
			play = new Play(attributes.getValue("id"), attributes.getValue("date"));
	   	} else if (qName.equalsIgnoreCase("item")) {
	   		play.setName(attributes.getValue("name"));
	   		play.setGameId(attributes.getValue("objectid"));
			
	   		game = attributes.getValue("name");
	   		if (plays.containsKey(game)) {
	   			int i = plays.get(game);
	   			i++;
	   			plays.put(game, i);
	   		} else {
	   			plays.put(game, 1);
	   		}
	   	} else if (qName.equalsIgnoreCase("player")) {
	   		Player player = new Player(attributes.getValue("name"), attributes.getValue("startposition"),
	   				 attributes.getValue("color"), attributes.getValue("score"), attributes.getValue("win").equals("1")?true:false);
			play.addPlayer(player);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("play")) {
			System.out.println(play.getPlayId() + "   " + play.getDate() + "   " + play.getGameId() + "   " + play.getName() + "   " + play.getPlayersToString());
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		for (String s : sortByValue(plays).keySet()) {
			System.out.println(s + ": " + plays.get(s));
		}
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
