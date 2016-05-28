package PlayPanel.WestPanel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Graphics.BtnGraphic;
import Interface.GameColor;
import Interface.GameSet;


public class ItemPanel extends JPanel{
	private static Item item[]=new Item[4];
	private static ItemBtnGra itemBtn[]=new ItemBtnGra[4];
	
	ItemPanel(){
		
		setLayout(null);
		setBackground(null);
		setPreferredSize(new Dimension(130,240));
		
		item[0]=new Item1();
		item[1]=new Item2();
		item[2]=new Item3();
		item[3]=new Item4();
		
		String path="images/MainFrame/"+GameSet.getCharacter() +"/PlayPanel/WestPanel/ItemPanel/";
		itemBtn[0]=new ItemBtnGra(path+"ItemBtn","item1", 100, 35);
		itemBtn[1]=new ItemBtnGra(path+"ItemBtn","item2", 100, 35);
		itemBtn[2]=new ItemBtnGra(path+"ItemBtn","item3", 100, 35);
		itemBtn[3]=new ItemBtnGra(path+"ItemBtn","item4", 100, 35);
		
		itemBtn[0].addla("모두 지우기", 15);
		itemBtn[1].addla("잠깐 멈추기", 15);
		itemBtn[2].addla("천천히", 15);
		itemBtn[3].addla("체력 회복", 15);
		
		for(int i=0; i<4; i++){
			itemBtn[i].setEnabled(false);
			itemBtn[i].setLocation(15,60+(i*40));
			add(itemBtn[i]);
		}			
	}
	
	public void paintComponent(Graphics g) {
		String path="images/MainFrame/"+GameSet.getCharacter() +"/PlayPanel/WestPanel/ItemPanel/";
		ImageIcon imgIcon=new ImageIcon(path+"background"+".png");
		g.drawImage(imgIcon.getImage(), 0, 0, null);	
		setOpaque(false);
		super.paintComponent(g);
	}
	
	//해당 인덱스의 아이템 리턴
	public static Item getItem(int index){
		return item[index];
	}
	
	//해당 인덱스의 아이템 버튼 리턴
	public static ItemBtnGra getItemBtn(int index){
		return itemBtn[index];
	}
	
	public class ItemBtnGra extends BtnGraphic{
		boolean enable;
		
		public ItemBtnGra(String path, String btnID, int width, int height) {
			super(path, btnID, width, height);
		}
		
		public void setEnabled(boolean enable){
			this.enable=enable;
			
			if(enable==true){
				this.setImgIcon(this.getPath()+".png");
				this.repaint();
			}
			else{
				this.setImgIcon(this.getPath()+"_false"+".png");
				this.repaint();
			}
		}
		
	}

}