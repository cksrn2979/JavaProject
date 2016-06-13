package PlayPanel.WestPanel;

import Graphics.GlobalGraphic;
import Graphics.GraphicButton;
import Graphics.GraphicPanel;
import MainFrame.MainFrame;


public class ItemPanel extends GraphicPanel{
	private Item item[]=new Item[4];
	private GraphicButton itemBtn[]=new GraphicButton[4];
	
	ItemPanel(String path, String FILENAME, int width, int height){
		super(path,FILENAME,width,height);
		setLayout(null);
		setBackground(null);
				
		item[0]=new Item1(this);
		item[1]=new Item2(this);
		item[2]=new Item3(this);
		item[3]=new Item4(this);
		
		String btnpath=GlobalGraphic.path+"WestPanel/";
		itemBtn[0]=new GraphicButton(btnpath,"ItemBtn1",100,35);
		itemBtn[1]=new GraphicButton(btnpath,"ItemBtn2",100,35);
		itemBtn[2]=new GraphicButton(btnpath,"ItemBtn3",100,35);
		itemBtn[3]=new GraphicButton(btnpath,"ItemBtn4",100,35);
		
		for(int i=0; i<4; i++){
			itemBtn[i].setLocation(15,10+(i*37));
			itemBtn[i].setEnabled(false);
			add(itemBtn[i]);
		}			
	}

	//해당 인덱스의 아이템 리턴
	public Item getItem(int index){
		return item[index];
	}
	
	//해당 인덱스의 아이템 버튼 리턴
	public GraphicButton getItemBtn(int index){
		return itemBtn[index];
	}
}