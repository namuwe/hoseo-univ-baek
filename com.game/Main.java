package com.game;

import javax.swing.*;

import com.game.Character.Player;

import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame implements KeyListener {
	int windowWidth = 1920;
	int windowHeight = 1080;
	int buttonWidth = 200;
	int buttonHeight = 60;
	
	Image mainmenuImage=new ImageIcon(Main.class.getResource("/image/mainmenu.jpg")).getImage();
	ImagePanel mainmenuPanel = new ImagePanel(mainmenuImage);
	Map map = new Map();
	Character.Player player = new Character.Player();
	MapData data = new MapData();
	CheckMove move = new CheckMove();
	
	JPanel mapPanel;
	
	public MainFrame () {
		this.setTitle("untitled RPG game");
		this.setSize(windowWidth,windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setResizable(false);
		mainmenuPanel.setLayout(null);
		
		Font buttonFont = new Font("고딕", Font.PLAIN, 20);
		
		//시작버튼
		JButton startButton = new JButton("게임 시작");
		startButton.setBounds(windowWidth/2-buttonWidth/2,windowHeight-buttonHeight*5, 200, 60);
		startButton.setFont(buttonFont);
		startButton.addActionListener(new startButtonAction());
		mainmenuPanel.add(startButton);
		
		//종료버튼
		JButton exitButton = new JButton("게임 종료");
		exitButton.setBounds(windowWidth/2-buttonWidth/2,windowHeight-(buttonHeight*4-15), 200, 60);
		exitButton.setFont(buttonFont);
		exitButton.addActionListener(new exitButtonAction());
		mainmenuPanel.add(exitButton);
		
		this.add(mainmenuPanel);
		this.setVisible(true);
	}
	
	
	class startButtonAction implements ActionListener {		//시작버튼 액선
		Map map = new Map();
		public void actionPerformed (ActionEvent a) {
			System.out.println("게임시작 버튼 작동");
			Map mainMap = new Map();
			remove(mainmenuPanel);
			mapPanel = mainMap.printMap(map.getWorldNum(), map.getMapNum());
			int mapRows = mainMap.getMapRows();
			int mapCols = mainMap.getMapCols();
			setSize(mapCols*50,mapRows*50);
			add(mapPanel);
			setLocationRelativeTo(null);
			revalidate();	//컴포넌트 재배치
            repaint();
            requestFocusInWindow();		//키 입력 초점을 윈도우로 변경
		}
	}

	class exitButtonAction implements ActionListener {		//종료버튼 액션
		public void actionPerformed (ActionEvent a) {
			System.exit(0);		//창 닫기
		}
	}
	class ImagePanel extends JPanel {
		private Image image;
	
		public ImagePanel(Image image) {
			this.image = image;
			setLayout(null);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode  = e.getKeyCode();
		switch(KeyCode) {
		case KeyEvent.VK_UP:
			if(data.allMapData[map.getWorldNum()][map.getMapNum()][player.getX()-1][Player.getY()]==0)
				player.setX(player.getX()-1);
			break;
		case KeyEvent.VK_DOWN:
			if(data.allMapData[map.getWorldNum()][map.getMapNum()][player.getX()+1][Player.getY()]==0)
				player.setX(player.getX()+1);
			break;
		case KeyEvent.VK_LEFT:
			if(data.allMapData[map.getWorldNum()][map.getMapNum()][player.getX()][Player.getY()-1]==0)
				player.setY(player.getY()-1);
			break;
		case KeyEvent.VK_RIGHT:
			if(data.allMapData[map.getWorldNum()][map.getMapNum()][player.getX()][Player.getY()+1]==0)
				player.setY(player.getY()+1);
			break;
		}
		System.out.println("x = "+Player.getX());
		System.out.println("y = "+Player.getY());
		
		remove(mapPanel);
		mapPanel = move.CheakMove(map.getWorldNum(), map.getMapNum(), map, player);
		this.add(mapPanel);
		this.setSize(map.getMapCols()*50,map.getMapRows()*50);
		this.setLocationRelativeTo(null);
		this.revalidate();
		this.repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class Main {
	public static void main(String[] args) {
		new MainFrame();
	}
}
