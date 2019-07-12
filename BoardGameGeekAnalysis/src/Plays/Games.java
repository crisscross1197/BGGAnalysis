package Plays;

public enum Games {

	SEVEN_WONDERS (68448, "7 Wonders"),
	TIEN_LEN (18103, "Tien Len"),
	TERRAFORMING_MARS (167791, "Terraforming Mars");
	
	private int gameID;
	private String name;
	
	private Games(int gameID, String name) {
		this.gameID = gameID;
		this.name = name;
	}

	public int getGameID() {
		return gameID;
	}

	public String getName() {
		return name;
	}
}
