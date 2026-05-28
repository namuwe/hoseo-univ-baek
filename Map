package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Map extends MapData{
	int mapRows = 0;
	int mapCols = 0;
	
	public int getMapRows() {
		return mapRows;
	}
	
	public int getMapCols() {
		return mapCols;
	}
	
	public JPanel printMap(int worldNumber,int mapNumber) {
		mapRows = allMapData[worldNumber][mapNumber].length;
		mapCols = allMapData[worldNumber][mapNumber][0].length;
		JPanel mapMainPanel = new JPanel();
		JPanel[][] mapTilePanel = new JPanel[mapRows][mapCols];
		mapMainPanel.setLayout(new GridLayout(mapRows,mapCols,0,0));
		//이미지
		Image tileImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
		Image wallImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
		Image treeImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
		Image rocksImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
		Image woterImage = new ImageIcon(getClass().getResource("/image/x.png")).getImage();
		
		switch(worldNumber) {
		case 0:	//마을 이미지 적용
		case 1:	//숲 이미지 적용
			tileImage = new ImageIcon(getClass().getResource("/image/forest_tile.png")).getImage();
			wallImage = new ImageIcon(getClass().getResource("/image/forest_wall.png")).getImage();
			treeImage = new ImageIcon(getClass().getResource("/image/forest_tree.png")).getImage();
			rocksImage = new ImageIcon(getClass().getResource("/image/forest_rocks.png")).getImage();
			woterImage = new ImageIcon(getClass().getResource("/image/forest_woter.png")).getImage();
			break;
		default:
			System.out.println("맵 이미지 적용중 오류가 발생하였습니다.");
			break;
		}
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
				//case 4:
					
				case 5:	//물
					mapTilePanel[i][j] = new tilePanel(woterImage);
					break;
				default:
					mapTilePanel[i][j] = new tilePanel(tileImage);
					break;
				}
				mapMainPanel.add(mapTilePanel[i][j]);
			}
		}
		
		return mapMainPanel;
	}
	
}

class tilePanel extends JPanel {
    private Image image;

    public tilePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // 타일 패널 크기에 맞게 이미지를 꽉 채워 그립니다.
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
