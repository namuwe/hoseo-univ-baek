package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame {
	int windowWidth = 1920;
	int windowHeight = 1080;
	int buttonWidth = 200;
	int buttonHeight = 60;
	int worldNumber = 1;
	int mapNumber = 3;
	
	Image mainmenuImage=new ImageIcon(Main.class.getResource("/image/mainmenu.jpg")).getImage();
	ImagePanel mainmenuPanel = new ImagePanel(mainmenuImage);
	
	public MainFrame () {
		this.setTitle("untitled RPG game");
		this.setSize(windowWidth,windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
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
	
	class startButtonAction implements ActionListener {
		public void actionPerformed (ActionEvent a) {
			JButton button = (JButton) a.getSource();
			System.out.println("게임시작 버튼 작동");
			Map mainMap = new Map();
			remove(mainmenuPanel);
			JPanel mapPanel = mainMap.printMap(worldNumber, mapNumber);
			int mapRows = mainMap.getMapRows();
			int mapCols = mainMap.getMapCols();
			setSize(mapCols*50,mapRows*50);
			add(mapPanel);
			setLocationRelativeTo(null);
			revalidate();
            repaint();
		}
	}
}

class exitButtonAction implements ActionListener {
	public void actionPerformed (ActionEvent a) {
		JButton button = (JButton) a.getSource();
		System.exit(0);
	}
}
class ImagePanel extends JPanel {
	private Image image;
	
	public ImagePanel(Image image) {
        this.image = image;
        setLayout(null); // 버튼들을 자유롭게 배치하기 위해 null 레이아웃 유지
    }
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 원래 JPanel이 해야 할 기본 배경 그리기 작업 수행
        if (image != null) {
            // 이 패널의 크기(getWidth(), getHeight())에 맞춰 이미지를 가득 채워 그립니다.
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Main {

	public static void main(String[] args) {
		new MainFrame();
	}
}
