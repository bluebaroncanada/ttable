package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

/**
 * The Class FGameMenu.
 */
public class FGameMenu extends BackgroundPanel {
	
	/**
	 * Instantiates a new f game menu.
	 *
	 * @param controller the controller
	 */
	public FGameMenu(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(50,150,5,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/fgame.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Drill Menu"), c);
		}
		
		c.ipady = 50;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridwidth = 1;
		c.insets = new Insets(10,150,0,150);
		
		JButton play = new JButton();
		play.addActionListener(new StartFinal(controller));
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/fgame/playgame.png"));
			play.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			play.setText("PLAY GAME!");
		}
		c.gridy = 1;
		add(play, c);
		
		c.gridwidth = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,150,0,150);

		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/highscores.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("High Scores"), c);
		}
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("High Scores");
		Vector<Vector<String>> highScores = new Vector<Vector<String>>();
		for (int i = 0; i < 2; i++) {
			Vector<String> v = new Vector<String>();
			v.add("1000");
			highScores.add(v);
		}
		
		
		DefaultTableModel tableModel = new DefaultTableModel(highScores, columnNames);
		tableModel.setRowCount(5);
		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		table.setOpaque(false);
		table.setRowHeight(32);
		table.setShowGrid(false);
		try {
			URL url = new URL("http://jbaron6.cs2212.ca/fonts/GiddyupStd.otf");
			URLConnection urlcon = url.openConnection();
			urlcon.setDoInput(true);
			urlcon.setUseCaches(false);
			Font font = Font.createFont(Font.TRUETYPE_FONT, urlcon.getInputStream());
			table.setFont(font.deriveFont(Font.BOLD, 30));
		} catch (FontFormatException | IOException e) {
			table.setFont(new Font("Serif", Font.BOLD, 30));
		}
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		renderer.setOpaque(false);
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setCellRenderer(renderer);
		
		
		c.insets = new Insets(0,150,0,150);
		c.gridy = 3;
		c.ipady = 0;
		add(table,c);
	}
}

/**
 * The Class StartFinal.
 */
class StartFinal implements ActionListener {

	private Controller controller;
	
	public StartFinal(Controller control) {
		super();
		controller = control;
	}
	
	public void actionPerformed(ActionEvent e) {
		FGame menu = new FGame(controller);
		controller.setScreen(menu);
	}
}
