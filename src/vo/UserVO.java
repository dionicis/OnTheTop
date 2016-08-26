package vo;

public class UserVO {
	private int id;
	private String name;
	private String tier;
	private String division;
	private int leaguePoints;
	private int wins;
	private int losses;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTier() {
		return tier;
	}

	public String getDivision() {
		return division;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public void showStatus(){
		System.out.print("name : "+ name);
		System.out.print("leagupoint : "+ leaguePoints);
		System.out.print("tier : "+ tier);
		System.out.print("division : "+ division);
		System.out.print("wins : "+ wins);
		System.out.print("losses : "+ losses);
		System.out.print("id : "+ id);
		System.out.println();

	}
}
