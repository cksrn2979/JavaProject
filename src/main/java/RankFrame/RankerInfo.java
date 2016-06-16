package RankFrame;

public class RankerInfo {
	private String character;
	private String name;
	private Integer score;
	
	RankerInfo(){ };
	public RankerInfo(String ch,String name,Integer score){
		this.character=ch;
		this.name=name;
		this.score=score;
	}
	
	public String getCharacter(){return character;}	
	public String getName(){return name;}	
	public Integer getScore(){return score;	}

}
