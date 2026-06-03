package com.game;

import javax.swing.*;
import java.awt.*;

class Move {
	int ex, ey;
	int sx, sy;
	int wx, wy;
	int nx, ny;
	int x, y;
	final static int diNorth = 0;	//북
	final static int diEast = 1;	//동
	final static int diSouth = 2;	//남
	final static int diWest = 3;	//서
	final static int town = 0;		//마을
	final static int forest = 1;	//숲
	final static int desert = 2;	//숲
	final static int cave = 3;		//숲
	final static int ruins = 4;		//숲
	
	public static int[][][][] MoveMap = {	//월드, 맵, 방위(북, 동, 남, 서), 좌표(x,y)
			{
				{{0,6},{4,11},{8,6},{4,0}}	//마을
			},
			{
				{{0,3},{0,0},{8,8},{0,0}},	//숲1
				{{0,2},{4,4},{8,2},{0,0}},	//숲2
				{{0,0},{0,0},{0,0},{2,0}},	//숲3
				{{0,0},{0,0},{8,5},{0,0}},	//숲4
			},
			{
				{{0,0},{5,9},{0,0},{5,0}},	//동굴1
				{{0,0},{5,9},{0,0},{5,0}},	//동굴2
				{{0,0},{5,9},{0,0},{5,0}},	//동굴3
				{{0,0},{0,0},{0,0},{5,0}},	//동굴4
			},
			{
				{{0,9},{10,19},{19,9},{0,0}},	//사막1
				{{0,0},{0,0},{19,9},{10,0}},	//사막2
				{{0,9},{0,0},{0,0},{10,0}},		//사막3
				{{0,9},{10,19},{0,0},{0,0}},	//사막4
			},
			{
				{{0,0},{7,14},{14,7},{7,0}},	//고대유적1
				{{0,0},{7,14},{14,6},{0,0}},	//고대유적2
				{{0,6},{7,14},{0,0},{0,0}},		//고대유적3
				{{0,7},{0,0},{0,0},{7,0}}		//고대유적4
			}
	};
	
	public static int getExitDirection(int world, int map, int px, int py) {
        if (world >= MoveMap.length || map >= MoveMap[world].length) return -1;

        for (int dir = 0; dir < 4; dir++) {
        	int exitX = MoveMap[world][map][dir][0];
        	int exitY = MoveMap[world][map][dir][1];
        	
        	if (px == exitX && py == exitY && exitX != -1)
        		return dir; // 0:북, 1:동, 2:남, 3:서
        }
        return -1;
    }
	
	class CheckMove extends Move {
		Move getXY = new Move();
	}
		static JPanel mapPanel = new JPanel();
		public static JPanel CheakMove(int worldNum, int mapNum, Map map, Character.Player player) {
			int dir = getExitDirection(worldNum, mapNum, player.getX(), player.getY());
			if(dir != -1) {
				System.out.println("맵 이동");
				switch(worldNum) {
				case town:		//마을
					switch(dir) {	//마을
					case diNorth:
						map.setWorldNum(1);
	                    map.setMapNum(0);
	                    player.setX(7);
	                    player.setY(8);
	                    break;
					case diEast:
						map.setWorldNum(2);
	                    map.setMapNum(0);
	                    player.setX(5);
	                    player.setY(1);
						break;
					case diSouth:
						map.setWorldNum(3);
	                    map.setMapNum(0);
	                    player.setX(1);
	                    player.setY(9);
	                    break;
					case diWest:
						map.setWorldNum(4);
						map.setMapNum(0);
						player.setX(7);
						player.setY(13);
						break;
					}break;
				case forest:	//숲
					switch(mapNum) {
					case 0:		//숲1
						switch(dir) {
						case diNorth:
							map.setWorldNum(1);
							map.setMapNum(1);
							player.setX(7);
							player.setY(2);
							break;
						case diSouth:
							map.setWorldNum(0);
							map.setMapNum(0);
							player.setX(1);
							player.setY(6);
							break;
						}break;
					case 1:		//숲2
						switch(dir) {
						case diNorth:
							map.setWorldNum(1);
							map.setMapNum(3);
							player.setX(8);
							player.setY(5);
							break;
						case diEast:
							map.setWorldNum(1);
							map.setMapNum(2);
							player.setX(2);
							player.setY(1);
							break;
						case diSouth:
							map.setWorldNum(1);
							map.setMapNum(0);
							player.setX(1);
							player.setY(3);
							break;
						}break;
					case 2:		//숲3
						switch(dir) {
						case diWest:
							map.setWorldNum(1);
							map.setMapNum(1);
							player.setX(4);
							player.setY(3);
							break;
						}break;
					case 3:		//숲4
						switch(dir) {
						case diSouth:
							map.setWorldNum(1);
							map.setMapNum(1);
							player.setX(1);
							player.setY(2);
							break;
						}break;
					}break;
					
				case cave:		//동굴
					switch(mapNum) {
					case 0:		//동굴1
						switch(dir) {
						case diEast:
							map.setWorldNum(2);
							map.setMapNum(1);
							player.setX(5);
							player.setY(1);
							break;
						case diWest:
							map.setWorldNum(0);
							map.setMapNum(0);
							player.setX(4);
							player.setY(10);
							break;
						}break;
					case 1:		//동굴2
						switch(dir) {
						case diEast:
							map.setWorldNum(2);
							map.setMapNum(2);
							player.setX(5);
							player.setY(1);
							break;
						case diWest:
							map.setWorldNum(2);
							map.setMapNum(0);
							player.setX(5);
							player.setY(8);
							break;
						}break;
					case 2:		//동굴3
						switch(dir) {
						case diEast:
							map.setWorldNum(2);
							map.setMapNum(3);
							player.setX(5);
							player.setY(1);
							break;
						case diWest:
							map.setWorldNum(2);
							map.setMapNum(1);
							player.setX(5);
							player.setY(8);
							break;
						}break;
					case 3:		//동굴4
						switch(dir) {
						case diEast:
							map.setWorldNum(2);
							map.setMapNum(3);
							player.setX(5);
							player.setY(1);
							break;
						case diWest:
							map.setWorldNum(2);
							map.setMapNum(2);
							player.setX(5);
							player.setY(8);
							break;
						}break;
					}break;
					
				case desert:	//사막
					switch(mapNum){
					case 0:		//사막1
						switch(dir) {
						case diNorth:
							map.setWorldNum(0);
		                    map.setMapNum(0);
		                    player.setX(7);
		                    player.setY(6);
		                    break;
						case diEast:
							map.setWorldNum(3);
		                    map.setMapNum(1);
		                    player.setX(10);
		                    player.setY(1);
		                    break;
						case diSouth:
							map.setWorldNum(3);
		                    map.setMapNum(3);
		                    player.setX(1);
		                    player.setY(9);
						}break;
					case 1:		//사막2
						switch(dir) {
						case diSouth:
							map.setWorldNum(3);
		                    map.setMapNum(2);
		                    player.setX(1);
		                    player.setY(9);
		                    break;
						case diWest:
							map.setWorldNum(3);
		                    map.setMapNum(0);
		                    player.setX(10);
		                    player.setY(18);
		                    break;
						}break;
					case 2:		//사막3
						switch(dir) {
						case diNorth:
							map.setWorldNum(3);
		                    map.setMapNum(1);
		                    player.setX(18);
		                    player.setY(9);
		                    break;
						case diWest:
							map.setWorldNum(3);
		                    map.setMapNum(3);
		                    player.setX(10);
		                    player.setY(18);
		                    break;
						}break;
					case 3:		//사막4
						switch(dir) {
						case diEast:
							map.setWorldNum(3);
		                    map.setMapNum(2);
		                    player.setX(10);
		                    player.setY(1);
		                    break;
						case diNorth:
							map.setWorldNum(3);
		                    map.setMapNum(0);
		                    player.setX(18);
		                    player.setY(9);
		                    break;
						}break;
					}break;
					
				case ruins:		//고대유적
					switch(mapNum) {
					case 0:		//고대유적1
						switch(dir) {
						case diEast:
							map.setWorldNum(0);
							map.setMapNum(0);
							player.setX(4);
							player.setY(1);
							break;
						case diSouth:
							map.setWorldNum(4);
							map.setMapNum(3);
							player.setX(1);
							player.setY(7);
							break;
						case diWest:
							map.setWorldNum(4);
							map.setMapNum(1);
							player.setX(7);
							player.setY(13);
							break;
						}break;
					case 1:		//고대유적2
						switch(dir) {
						case diEast:
							map.setWorldNum(4);
							map.setMapNum(0);
							player.setX(7);
							player.setY(1);
							break;
						case diSouth:
							map.setWorldNum(4);
							map.setMapNum(2);
							player.setX(1);
							player.setY(6);
							break;
						}break;
					case 2:		//고대유적3
						switch(dir) {
						case diNorth:
							map.setWorldNum(4);
							map.setMapNum(1);
							player.setX(13);
							player.setY(6);
							break;
						case diEast:
							map.setWorldNum(4);
							map.setMapNum(3);
							player.setX(7);
							player.setY(1);
							break;
						}break;
					case 3:		//고대유적4
						switch(dir) {
						case diNorth:
							map.setWorldNum(4);
							map.setMapNum(0);
							player.setX(13);
							player.setY(7);
							break;
						case diWest:
							map.setWorldNum(4);
							map.setMapNum(2);
							player.setX(7);
							player.setY(13);
							break;
						}break;
					}break;
				}
			}
			mapPanel = map.printMap(map.getWorldNum(), map.getMapNum());
			return mapPanel;
			}
		}
