package Plays;

import java.util.ArrayList;
import java.util.List;

public class Play {

	private String playId;
	private String date;
	private String name;
	private String gameId;
	private List<Player> players = new ArrayList<Player>();
	
	public Play(String playId, String date) {
		this.playId = playId;
		this.date = date;
	}	
	
	public String getPlayId() {
		return playId;
	}

	public void setPlayId(String playId) {
		this.playId = playId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getPlayersToString() {
		String ret = "";
		for (Player p : players) {
			ret = ret + p.getName() + " ";
		}
		return ret;
	}
}
