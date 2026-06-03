package com.game;

import javax.swing.*;
import java.awt.*;

class Move {
	int ex, ey;
	int sx, sy;
	int wx, wy;
	int nx, ny;
	int x, y;
	final int diNorth = 0;	//북
	final int diEast = 1;		//동
	final int diSouth = 2;	//남
	final int diWest = 3;		//서
	final int mapX = 0;
	final int mapY = 1;
	
	public int[][][][] MoveMap = {	//월드, 맵, 방위(북, 동, 남, 서), 좌표(x,y)
			{
				{{0,6}}
			},
			{
				{{0,3},{0,0},{8,8},{0,0}},	//숲1
				{{2,0},{4,4},{3,0},{0,0}},	//숲2
				{{0,0},{0,0},{0,0},{2,0}}	//숲3
				//{{},{},{},{}},
			}
	};
	class CheckMove extends Move {
		Move getXY = new Move();
	}
		JPanel mapPanel = new JPanel();
		public JPanel CheakMove(int worldNum, int mapNum, Map map, Character.Player player) {
			switch(worldNum) {
			case 0:
				if(CheckTrueFalse(player, MoveMap, worldNum, mapNum)) {
					map.setWorldNum(1);
					map.setMapNum(0);
					player.setX(7);
					player.setY(8);
				}
				break;
				
			case 1:
				switch(mapNum) {
				case 0:		//숲1
					getXY = getXY.Forest1ToTown();
					if(CheckTrueFalse(player, getXY)) {
						map.setWorldNum(0);
						map.setMapNum(0);
						player.setX(1);
						player.setY(6);
					}
					else {
						getXY = getXY.Forest1ToForest2();
						if(CheckTrueFalse(player, getXY)) {
							map.setWorldNum(1);
							map.setMapNum(1);
							player.setX(7);
							player.setY(2);
						}
					}break;
					
				case 1:		//숲2
					getXY = getXY.Forest2ToForest1();
					if(CheckTrueFalse(player, getXY)) {
						map.setWorldNum(1);
						map.setMapNum(0);
						player.setX(1);
						player.setY(3);
					}
					else {
						getXY = getXY.Forest2ToForest3();
						if(CheckTrueFalse(player, getXY)) {
							map.setWorldNum(1);
							map.setMapNum(2);
							player.setX(2);
							player.setY(1);
						}
					}break;
					case 2:		//숲3
						getXY = getXY.Forest3ToForest2();
						if(CheckTrueFalse(player, getXY)) {
							map.setWorldNum(1);
							map.setMapNum(1);
							player.setX(4);
							player.setY(3);
						}break;
					case 3:		//숲4
						getXY = getXY.Forest2ToForest4();
						if(CheckTrueFalse(player, getXY)) {
							map.setWorldNum(1);
							map.setMapNum(0);
							player.setX(1);
							player.setY(3);
						}
						else {
							getXY = getXY.Forest2ToForest4();
							if(CheckTrueFalse(player, getXY)) {
								map.setWorldNum(1);
								map.setMapNum(2);
								player.setX(2);
								player.setY(1);
							}
						}break;
				}
			}
			mapPanel = map.printMap(map.getWorldNum(), map.getMapNum());
			return mapPanel;
		}
		boolean CheckTrueFalse(Character.Player player, int[][][][] MoveMap, int worldMax, int mapMax) {
			for(int world = 0;world<worldMax;world++) {
				for(int map = 0;map<mapMax;map++) {
					if(MoveMap[world][map][diNorth][mapX]==player.getX() && MoveMap[world][map][diNorth][mapY]==player.getY()) {
						
					}
					}
			}
			if (player.getX() == getXY.x && player.getY() == getXY.y)
				return true;
			else
				return false;
		}
	}
}
