package com.game;

import com.game.MapData;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

	public static void main(String[] args) {
		int gameSence = 0; //0 : 메인메뉴, 1 : 게임 화면, 2 : 설정, 3 : 나가기, 4 : 크레딧
		
		JFrame frame = new JFrame();
		JPanel game = new JPanel();	//JPanel 작성부터 다시할 것
		
		frame.setSize(640,480);
		frame.setTitle("untitled RPG game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		MapData Map = new MapData ();
		
		 System.out.println(Map.Forest_1_name);
		Map.printMapData(Map.Forest_1_mapData);
		System.out.println(Map.Forest_2_name);
		Map.printMapData(Map.Forest_2_mapData);
		System.out.println(Map.Forest_3_name);
		Map.printMapData(Map.Forest_3_mapData);
		System.out.println(Map.Forest_4_name);
		Map.printMapData(Map.Forest_4_mapData);
		System.out.println(Map.Cave_1_name);
		Map.printMapData(Map.Cave_1_mapData);
		System.out.println(Map.Cave_2_name);
		Map.printMapData(Map.Cave_2_mapData);
		System.out.println(Map.Cave_3_name);
		Map.printMapData(Map.Cave_3_mapData);
		System.out.println(Map.Cave_4_name);
		Map.printMapData(Map.Cave_4_mapData);
		System.out.println(Map.Desert_1_name);
		Map.printMapData(Map.Desert_1_mapData);
		System.out.println(Map.Desert_2_name);
		Map.printMapData(Map.Desert_2_mapData);
		System.out.println(Map.Desert_3_name);
		Map.printMapData(Map.Desert_3_mapData);
		System.out.println(Map.Desert_4_name);
		Map.printMapData(Map.Desert_4_mapData);
		System.out.println(Map.ruins_1_name);
		Map.printMapData(Map.ruins_1_mapData);
		System.out.println(Map.ruins_2_name);
		Map.printMapData(Map.ruins_2_mapData);
		System.out.println(Map.ruins_3_name);
		Map.printMapData(Map.ruins_3_mapData);
		System.out.println(Map.ruins_3_name);
		Map.printMapData(Map.ruins_4_mapData);
		
	}
}
