package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Map extends MapData {
	static int mapRows = 0;
	static int mapCols = 0;
	int worldNum = 0;
	int mapNum = 0;
	Image tileImage;
	Image wallImage;
	Image treeImage;
	Image rocksImage;
	Image woterImage;
	Image houseImage = new ImageIcon(getClass().getResource("/image/house.png")).getImage();
	tilePanel[][] mapTilePanel;
	JPanel mapMainPanel;
	
	public int getMapRows() {		//맵 출력할 때 사용
		return mapRows;
	}
	public int getMapCols() {		//맵 출력할 때 사용
		return mapCols;
	}
	public int getWorldNum() {		//현재 월드 번호 불러오기
		return worldNum;
	}
	public int setWorldNum(int num) {	//현재 월드 번호 수정하기
		worldNum = num;
		return worldNum;
	}
	public int getMapNum() {		//현재 맵 번호 불러오기
		return mapNum;
	}
	public int setMapNum(int num) {	//현재 맵 번호 수정하기
		mapNum = num;
		return mapNum;
	}
	
	public void changeImage (int worldNumber) {	//이미지 변경
		switch(worldNumber) {
		case 0:		//마을
		case 1:		//숲
			tileImage = new ImageIcon(getClass().getResource("/image/forest_tile.png")).getImage();
			wallImage = new ImageIcon(getClass().getResource("/image/forest_wall.png")).getImage();
			treeImage = new ImageIcon(getClass().getResource("/image/forest_tree.png")).getImage();
			rocksImage = new ImageIcon(getClass().getResource("/image/forest_rocks.png")).getImage();
			woterImage = new ImageIcon(getClass().getResource("/image/forest_woter.png")).getImage();
			break;
		case 2:		//사막
			break;
		default:	//worldNumber값이 숲~고대유적 값이 아닐때
			tileImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
			wallImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
			treeImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
			rocksImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
			woterImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
			System.out.println("맵 이미지 적용중 오류가 발생하였습니다.");
			break;
			}
		}
	
	public JPanel printMap(int worldNumber,int mapNumber) {
		mapRows = allMapData[worldNumber][mapNumber].length;
		mapCols = allMapData[worldNumber][mapNumber][0].length;
		mapMainPanel = new JPanel();
		mapTilePanel = new tilePanel[mapRows][mapCols];
		mapMainPanel.setLayout(new GridLayout(mapRows,mapCols,0,0));
		Character.Player player = new Character.Player();
		
		changeImage(worldNumber);		//월드에 따라 이미지 변경
		
		for(int i=0;i<mapRows;i++) {
			for(int j=0;j<mapCols;j++) {
				switch(allMapData[worldNumber][mapNumber][i][j]) {
				case 0:	//바닥
					mapTilePanel[i][j] = new tilePanel(tileImage);
					break;
				case 1:	//벽
					mapTilePanel[i][j] = new tilePanel(wallImage);
					break;
				case 2:	//나무
					mapTilePanel[i][j] = new tilePanel(treeImage);
					break;
				case 3:	//바위
					mapTilePanel[i][j] = new tilePanel(rocksImage);
					break;
				case 4:	//집
					mapTilePanel[i][j] = new tilePanel(houseImage);
					break;
				case 5:	//물
					mapTilePanel[i][j] = new tilePanel(woterImage);
					break;
				default:
					mapTilePanel[i][j] = new tilePanel(tileImage);
					break;
				}
				if (player.getX() == i && player.getY() == j)
					mapTilePanel[i][j].setObjectImage(Character.Player.PlayerImage);
				
				mapMainPanel.add(mapTilePanel[i][j]);
			}
		}
		return mapMainPanel;
	}
}

class tilePanel extends JPanel {
    private Image bgImage;       //바닥 이미지
    private Image objectImage;   //오브첵트 이미지

    public tilePanel(Image bgImage) {	//타일 그릴 때 사용
        this.bgImage = bgImage;
        setLayout(null); 
    }

    public void setObjectImage(Image objectImage) {	//타일 위에 오브젝트 올릴 때 사용
        this.objectImage = objectImage;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 패널 초기화
        
        //배경 그리기
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
        
        //오브젝트 올리기
        if (objectImage != null) {
            g.drawImage(objectImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
