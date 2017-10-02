package com.tictactoe;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.MatrixLogic.Logic;


public class TicTacToeUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 41L;
	private CustomButton[] buttons = new CustomButton[9];
	private JLabel xLabel ;
	private JLabel oLabel ;
	private JButton reset ;
	private Logic logic = new Logic();
	private int xWin = 0;
	private int oWin = 0;
	private final int arraySize = 3;
	

	public TicTacToeUI() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(4, 3));
		reset = new JButton("RESET");
		reset.setActionCommand("reset");
		xLabel = new JLabel("X Wins");
		oLabel = new JLabel("O Wins");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetUI();
			}
		});
		add(xLabel);
		add(reset);
		add(oLabel);
		intinatilzeButtons();
		init();
	}

	public TicTacToeUI(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	private void init(){
		xLabel.setText("X Wins "+xWin);
		oLabel.setText("O Wins "+oWin);
		for(int i=0; i<9;i++){
			buttons[i].setActionCommand(""+i);
			if(buttons[i].getActionListeners().length <= 0 ){
				buttons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						CustomButton button = (CustomButton) e.getSource();
						button.removeActionListener(this);
						if(Logic.getStart() == 0){
							button.setDrawO(true);
							checkLogic();
						}
						else if(Logic.getStart() == 1){
							button.setDrawX(true);
							checkLogic();
						}
						Logic.setStart(Logic.getStart() == 0 ? 1 : 0);
					}
				});
			}
			buttons[i].setDrawO(false);
			buttons[i].setDrawX(false);
			add(buttons[i]);
		}
	}
	
	private void intinatilzeButtons(){
		for(int j=0 ; j<9 ;j++){
			this.buttons[j] = new CustomButton();
		}
	}
	private void resetUI(){
		init();
		Logic.setStart(0);
		this.repaint();
	}
	
	private void checkLogic(){
		int[] matrix = new int[9];
		for(int i = 0; i < 9; i++)
		{  
			   if(this.buttons[i].isDrawO()){
				   matrix[i] = 0;
			   }
			   else if(this.buttons[i].isDrawX()){
				   matrix[i] = 1;
			   }
			   else{
				   matrix[i] = 2;
			   }
		}
		if(logic.checkLogic(matrix, arraySize)){
			JOptionPane.showMessageDialog(this, "Win "+Logic.getStart());
			if(Logic.getStart() == 0)
				oWin++;
			else
				xWin++;
			resetUI();
		}
	}	
}
