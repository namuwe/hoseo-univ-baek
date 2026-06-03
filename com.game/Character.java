package com.game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Character {

	public static class Player {
		private static final String name = "테스트";
		private static int x = 4;
		private static int y = 6;
		public static final Image PlayerImage = new ImageIcon(Character.class.getResource("/image/player.png"))
				.getImage();
		public static int getX() {
			return x;
		}

		public static void setX(int x) {
			Player.x = x;
		}

		public static int getY() {
			return y;
		}

		public static void setY(int y) {
			Player.y = y;
		}
	}
}
