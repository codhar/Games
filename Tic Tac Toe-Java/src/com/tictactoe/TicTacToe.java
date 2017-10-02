package com.tictactoe;
import javax.swing.JFrame;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame tictactoe = new JFrame();
		TicTacToeUI ui = new TicTacToeUI();
		tictactoe.add(ui);
		tictactoe.setVisible(true);
		tictactoe.setSize(500, 500);
		tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
