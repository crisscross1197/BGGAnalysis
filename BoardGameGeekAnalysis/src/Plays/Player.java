package Plays;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Integer> positions;
	
	private String startPosition;
	private String color;
	private String score;
	private Boolean win;
	
	public String getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}

	public Player(String name, String startPosition, String color, String score, Boolean win) {
		super();
		this.name = name;
		this.startPosition = startPosition;
		this.color = color;
		this.score = score;
		this.win = win;
	}

	public Player(String name) {
		this.name = name;
		this.positions = new ArrayList<>();
	}

	public Player(String name, ArrayList<Integer> positions) {
		this.name = name;
		this.positions = positions;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Integer> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Integer> positions) {
		this.positions = positions;
	}

	public void addPosition(int pos) {
		this.positions.add(pos);
	}
}
