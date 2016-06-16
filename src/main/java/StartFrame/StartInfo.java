package StartFrame;

public class StartInfo {
	private String user;
	private String character;
	private Integer level;

	StartInfo(String user, String chracter,Integer level) {
		this.user = user;
		this.character = chracter;
		this.level=level;
	}
	
	public String getCharacter(){return character;}	
	public String getUser(){return user;}
	public Integer getLevel() {	return level;}

}
