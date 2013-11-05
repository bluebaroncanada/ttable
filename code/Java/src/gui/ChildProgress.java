package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

// TODO: Auto-generated Javadoc
/**
 * The Class ChildProgress.
 */
public class ChildProgress extends BackgroundPanel {
	
	//private Progeny child;
	
	/**
	 * Instantiates a new child progress.
	 *
	 * @param controller the controller
	 * @param settingsPane the settings pane
	 */
	public ChildProgress(Controller controller, Settings settingsPane/*, Progeny child*/) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0,0,0,0);
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = 1;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		JButton backArrow = new JButton();
		backArrow.setContentAreaFilled(false);
		backArrow.setBorderPainted(false);
		backArrow.addActionListener(new BackToSettings(controller, settingsPane));
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/backarr.png"));
			backArrow.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			backArrow.setText("<--");
		}
		add(backArrow, c);
		
		JLabel title = new JLabel(/*child.getName() + */"'s Progress");
		title.setFont(controller.getFont().deriveFont(Font.BOLD, 32));
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,75,5,75);
		c.gridy = 1;
		add(title, c);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Level");
		columnNames.add("Attempts");
		columnNames.add("Final Time (sec)");
		columnNames.add("Final Mistakes");
		
		Vector<Vector<String>> progress = new Vector<Vector<String>>();
		for (int i = 0; i <6; i++) {
			Vector<String> v = new Vector<String>();
			v.add("1");
			v.add("2");
			v.add("23");
			v.add("0");
			progress.add(v);
			Vector<String> v1 = new Vector<String>();
			v1.add("2");
			v1.add("5");
			v1.add("26");
			v1.add("2");
			progress.add(v1);
		}

		DefaultTableModel tableModel = new DefaultTableModel(progress, columnNames);
		tableModel.setNumRows(12);
		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		renderer.setOpaque(false);
		TableColumn col = null;
		for (int i = 0; i < table.getColumnCount(); i++) {
			col = table.getColumnModel().getColumn(i);
			col.setCellRenderer(renderer);
			col.setWidth(100);
		}
		table.setOpaque(false);
		table.setRowHeight(24);
		table.setShowGrid(false);
		table.getTableHeader().setDefaultRenderer(renderer);
		
		table.setFont(controller.getFont().deriveFont(Font.BOLD, 18));
		table.getTableHeader().setFont(controller.getFont().deriveFont(Font.BOLD, 18));
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		c.insets = new Insets(0,75,0,75);
		c.gridwidth = 1;
		c.gridy = 2;
		c.ipady = 300;
		c.ipadx = 500;
		add(scroll,c);
	}
}

/**
 * The Class BackToSettings.
 */
class BackToSettings implements ActionListener {

	private Controller controller;
	private Settings settingsPane;
	
	/**
	 * Instantiates a new BackToSettings listener.
	 * 
	 * @param the controller
	 * @param the settingsPane
	 */
	public BackToSettings(Controller controller, Settings settingsPane) {
		super();
		this.controller = controller;
		this.settingsPane = settingsPane;
	}
	
	/**
	 * Performs the action on event.
	 * 
	 * @param the action event
	 */
	public void actionPerformed(ActionEvent e) {
		controller.setScreen(settingsPane);
	}
}
