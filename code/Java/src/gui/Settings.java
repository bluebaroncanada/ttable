package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

/**
 * The Class Settings.
 */
public class Settings extends BackgroundPanel {
	
	/**
	 * Instantiates a new settings.
	 *
	 * @param controller the controller
	 */
	public Settings(Controller controller) {
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(10,150,10,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/settings.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Parent Mode"), c);
		}
		c.insets = new Insets(10,0,0,3);
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		
		Vector<String> sortOptions = new Vector<String>();
		sortOptions.add("Age");
		sortOptions.add("Name");
		JComboBox<String> sortMenu = new JComboBox<String>(sortOptions);
		add(sortMenu, c);
		
		c.insets = new Insets(10,0,0,75);
		c.gridx = 5;
		JButton sortButton = new JButton("Sort");
		add(sortButton, c);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Name");
		columnNames.add(" ");
		columnNames.add("Birthday");
		columnNames.add(" ");
		columnNames.add("Age");
		columnNames.add("Level");
		Vector<Vector<String>> children = new Vector<Vector<String>>();
		for (int i = 0; i <10; i++) {
		Vector<String> v = new Vector<String>();
		v.add("Wallace");
		v.add("22");
		v.add("September");
		v.add("1963");
		v.add("50");
		v.add("1");
		children.add(v);
		Vector<String> v1 = new Vector<String>();
		v1.add("Grommit");
		v1.add("14");
		v1.add("July");
		v1.add("2008");
		v1.add("5");
		v1.add("12");
		children.add(v1);
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(children, columnNames);
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
		c.gridwidth = 6;
		c.gridy = 2;
		c.gridx = 0;
		c.ipady = 80;
		add(scroll,c);
		
		JLabel addChild = new JLabel("Add Child:");
		JPanel adpanel = new JPanel();
		adpanel.add(addChild);
		c.gridwidth = 2;
		c.ipady = 0;
		c.insets = new Insets(10,75,0,0);
		c.gridy = 3;
		c.gridx = 0;
		add(addChild, c);
		
		JTextField nameInput = new JTextField("--Name--");
		c.insets = new Insets(0,75,0,0);
		c.gridwidth = 2;
		c.ipadx = 250;
		c.gridy = 4;
		c.gridx = 0;
		add(nameInput, c);
		
		Vector<String> d = new Vector<String>();
		d.add("Day");
		for (int i = 1; i <= 31; i++) {
			d.add("" + i);
		}
		JComboBox<String> days = new JComboBox<String>(d);
		c.gridwidth = 1;
		c.ipadx = 0;
		c.insets = new Insets(0,0,0,0);
		c.gridx = 2;
		add(days, c);
		
		Vector<String> m = new Vector<String>();
		m.add("Month");
		m.add("Jan");
		m.add("Feb");
		m.add("Mar");
		m.add("Apr");
		m.add("May");
		m.add("Jun");
		m.add("Jul");
		m.add("Aug");
		m.add("Sept");
		m.add("Oct");
		m.add("Nov");
		m.add("Dec");
		
		JComboBox<String> months = new JComboBox<String>(m);
		c.gridx = 3;
		add(months, c);
		
		Vector<String> y = new Vector<String>();
		y.add("Year");
		for (int i = 2013; i > 1980; i--) {
			y.add("" + i);
		}
		JComboBox<String> years = new JComboBox<String>(y);
		c.gridx = 4;
		add(years, c);
		
		JButton add = new JButton("Add");
		c.insets = new Insets(0,0,0,75);
		c.gridx = 5;
		add(add, c);
		
		JLabel editChild = new JLabel("Review and Modify Child:");
		c.insets = new Insets(20,75,0,0);
		c.gridwidth = 2;
		c.gridy = 5;
		c.gridx = 0;
		add(editChild, c);
		
		Vector<String> childnames = new Vector<String>();
		childnames.add("Wallace");
		childnames.add("Grommit");
		JComboBox<String> childSelect = new JComboBox<String>(childnames);
		c.insets = new Insets(0,75,0,0);
		c.gridy = 6;
		c.gridx = 0;
		add(childSelect, c);
		
		JComboBox<String> days2 = new JComboBox<String>(d);
		c.insets = new Insets(0,0,0,0);
		c.gridwidth = 1;
		c.gridx = 2;
		add(days2, c);
		
		JComboBox<String> months2 = new JComboBox<String>(m);
		c.gridx = 3;
		add(months2, c);
		
		JComboBox<String> years2 = new JComboBox<String>(y);
		c.gridx = 4;
		add(years2, c);
		
		Vector<String> l = new Vector<String>();
		for (int i = 1; i < 13; i++) {
			l.add("Level " + i);
		}
		JComboBox<String> levels = new JComboBox<String>(l);
		c.insets = new Insets(0,0,0,75);
		c.gridy = 6;
		c.gridx = 5;
		add(levels, c);
		
		JButton update = new JButton("Update");
		c.insets = new Insets(0,0,0,0);
		c.gridy = 7;
		c.gridx = 3;
		add(update, c);
		
		JButton remove = new JButton("Remove");
		c.gridx = 4;
		add(remove, c);
		
		JButton stats = new JButton("Progress");
		stats.addActionListener(new PressProgress(childSelect, controller, this));
		c.insets = new Insets(0,0,0,75);
		c.gridx = 5;
		add(stats, c);
		
		c.insets = new Insets(10,75,0,0);
		c.gridwidth = 2;
		c.gridy = 8;
		c.gridx = 0;
		add(new JLabel("Drill Settings:"), c);
		
		c.gridwidth = 1;
		c.gridy = 9;
		add(new JLabel("Time per question:"), c);
		
		Vector<String> t = new Vector<String>();
		for (int i = 5; i <= 120; i += 5) {
			t.add(i + " sec");
		}
		JComboBox<String> time = new JComboBox<String>(t);
		c.insets = new Insets(0,0,0,0);
		c.gridx = 1;
		add(time, c);
		
		c.gridwidth = 2;
		c.gridx = 2;
		add(new JLabel("Number of Errors per Level:"), c);
		
		Vector<String> err = new Vector<String>();
		for (int i = 0; i < 10; i++) {
			err.add("" + i);
		}
		JComboBox<String> errors = new JComboBox<String>(err);
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,75);
		c.gridx = 4;
		add(errors, c);
		
		c.insets = new Insets(0,75,0,0);
		c.gridx = 0;
		c.gridy = 10;
		add(new JLabel("Testing mode:"), c);
		
		ButtonGroup teststate = new ButtonGroup();
		
		JRadioButton testoff = new JRadioButton("Off");
		teststate.add(testoff);
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,0);
		c.gridx = 1;
		add(testoff, c);
		
		JRadioButton teston = new JRadioButton("On");
		teststate.add(teston);
		c.gridx = 2;
		add(teston, c);
		
		JButton apply = new JButton("Apply");
		c.gridx = 4;
		add(apply, c);
	}
}

class PressProgress implements ActionListener {

	private Controller controller;
	private JComboBox<String> childnames;
	private Settings settingsPane;
	
	public PressProgress(JComboBox<String> childnames, Controller controller, Settings settingsPane) {
		super();
		this.controller = controller;
		this.childnames = childnames;
		this.settingsPane = settingsPane;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = new String(childnames.getSelectedItem().toString());
		//Use name to lookup progeny
		ChildProgress screen = new ChildProgress(controller, settingsPane/*, Progeny child*/);
		controller.setScreen(screen);
	}
}