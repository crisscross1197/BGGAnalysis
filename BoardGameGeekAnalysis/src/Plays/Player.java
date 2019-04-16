package Plays;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Integer> positions;
	
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
