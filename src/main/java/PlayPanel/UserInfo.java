package PlayPanel;

import Dictionary.UserDictionary;

public class UserInfo {
	private String user;
	private String character;

	UserInfo(String user, String chracter) {
		this.user = user;
		this.character = chracter;
		
	}
	
	public String getCharacter(){return character;}	
	public String getUser(){return user;}
}
