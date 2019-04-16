package Plays;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TienLenPlaysHandler extends DefaultHandler {
	
   	private ArrayList<Player> players = new ArrayList<Player>();

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("play")) {
//			String playId = attributes.getValue("id");
//			String date = attributes.getValue("date");
//			System.out.println("Play ID : " + playId + " played on: " + date);
	   	} else if (qName.equalsIgnoreCase("player")) {
	   		String playerName = attributes.getValue("name");
	   		if (playerName.equals("Kyzaa")) {
	   			playerName = "Kris";
	   		}
	   		if (players.isEmpty()) {
	   			players.add(new Player(playerName));
	   		} else {
	   			boolean playerExists = false;
		   		for (Player player : players) {
		   			if (player.getName().equals(playerName)) {
		   				playerExists = true;
		   			}
		   		}
		   		if (!playerExists) {
		   			players.add(new Player(playerName));
		   		}
	   		}
	   		
	   		int pos = 4;
	   		switch (attributes.getValue("score")) {
			case "4":
				pos = 1;
				break;
			case "3":
				pos = 2;
				break;
			case "2":
				pos = 3;
				break;
			default:
				pos = 4;
				break;
			}
	   		
	   		for (Player player : players) {
	   			if (player.getName().equals(playerName)) {
	   				player.addPosition(pos);
	   				break;
	   			}
	   		}
	   	}
	}

	@Override
	public void endDocument() throws SAXException {
		for (Player player : players) {
			ArrayList<Integer> positions = player.getPositions();
			
			System.out.println("Player: " + player.getName());
			double sum = 0;
			double plays = positions.size();
			for (Integer pos : positions) {
				sum += pos;
			}
			double average = sum / plays;
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println("   Average Position: " + df.format(average));
			System.out.println("   Positions:");

			int sumPosition = 0;
			for (int i = 0; i < players.size(); i++) {
				for (Integer pos : positions) {
					if (i + 1 == pos) {
						sumPosition++;
					}
				}
				System.out.print("      " + (i + 1) + ". - " + sumPosition + "  ");
				for (int j = 0; j < sumPosition; j++) {
					System.out.print("#");
				}
				System.out.println();
				sumPosition = 0;
			}
			System.out.println();
		}
	}
	
}
