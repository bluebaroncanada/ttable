package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * The Class StatsMenu.
 */
public class StatsMenu extends BackgroundPanel {
	
	/**
	 * Instantiates a new stats menu.
	 *
	 * @param controller the controller
	 */
	public StatsMenu(Controller controller) {
		
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//-------------------------------------------------------------------------------------------------		
		// Add the logo		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(10,150,10,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/stats.png"));
			add(new JLabel(new ImageIcon(img)), c);
		} catch (IOException e) {
			add(new JLabel("Stats & Scores"), c);
		}

		//-------------------------------------------------------------------------------------------------		
		//Tabs
		JTabbedPane tabs = new JTabbedPane();
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		JPanel tab3 = new JPanel();
		tab1.setLayout(new GridBagLayout());
		tab2.setLayout(new GridBagLayout());
		tab3.setLayout(new GridBagLayout());
		fillTabFriends(tab1, c);
		fillTabAge(tab2, c);
		fillTabLevels(tab3, c);
		
		// Add the tabs
		tabs.addTab("Friends", tab1);
		tabs.addTab("By Age", tab2);
		tabs.addTab("By Level", tab3);
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.CENTER;
		c.insets = new Insets(10,150,10,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		add(tabs, c);


		
	}
	
	/**
	 * Fill tab friends.
	 *
	 * @param tab1 the tab1
	 * @param c the c
	 */
	private void fillTabFriends(JPanel tab1, GridBagConstraints c){
		// Headers	
		
		c.insets = new Insets(5,5,5,10);
		c.gridx = 0;
		c.gridwidth = 2;
		c.gridheight =1;
		c.gridy = 0;
		tab1.add(new JLabel("Friends"), c);
		c.gridx = 2;
		c.gridwidth = 1;
		tab1.add(new JLabel("Children"), c);
		c.gridx = 3;
		tab1.add(new JLabel("Age"), c);
		c.gridx = 4;
		tab1.add(new JLabel("Level"), c);
		//-------------------------------------------------------------------------------------------------		
		// Profile Pictures
		c.gridx = 0;
		c.gridy=2;
		c.gridheight =4;	
		for(int i=1; i<6;i++){
			
			try	{
				Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/profilePictures/"+i+".jpg"));
				JLabel pic = new JLabel(new ImageIcon(getScaledImage(img, 55,55)));
				tab1.add(pic, c);
			} catch (IOException e) {
				tab1.add(new JLabel("Profile Picture"), c);
			}
			c.gridy=(i*5)+2;
		}

		//-------------------------------------------------------------------------------------------------	
		// Friends names
		c.gridy = 2;
		c.gridx= 1;
		c.gridwidth =1;
		tab1.add(new JLabel("James Anderson"), c);
		c.gridy+=5;
		tab1.add(new JLabel("Yaqzan Ali"), c);
		c.gridy+=5;
		tab1.add(new JLabel("Chuhan Frank"), c);
		c.gridy+=5;
		tab1.add(new JLabel("Taylor Joseph"), c);
		c.gridy+=5;
		tab1.add(new JLabel("James Baron"), c);

		//-------------------------------------------------------------------------------------------------		
		// Children Names
		c.insets = new Insets(0,10,0,0);
		c.gridy = 2;
		c.gridx = 2;
		c.gridheight = 1;
		tab1.add(new JLabel("Lisa"), c);
		c.gridy++;
		tab1.add(new JLabel("Bart"), c);
		c.gridy+=4;
		
		tab1.add(new JLabel("Troy"), c);
		c.gridy++;
		tab1.add(new JLabel("Abed"), c);
		c.gridy++;
		tab1.add(new JLabel("Britta"), c);
		c.gridy+=3;

		tab1.add(new JLabel("Sheldon"), c);
		c.gridy+=5;
		tab1.add(new JLabel("Leslie"), c);
		c.gridy++;
		tab1.add(new JLabel("Ron"), c);
		c.gridy+=4;
		tab1.add(new JLabel("Dwight"), c);
		c.gridy++;
		tab1.add(new JLabel("Jim"), c);
		c.gridy++;
		tab1.add(new JLabel("Michael"), c);
		c.gridy++;
		tab1.add(new JLabel("Pam"), c);
		
		
		//-------------------------------------------------------------------------------------------------	
		// Age
		c.insets = new Insets(0,10,0,10);
		c.gridx = 3;
		c.gridy = 2;
		
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy+=4;
		
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy+=3;

		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy+=5;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy+=4;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		c.gridy++;
		tab1.add(new JLabel((Integer.toString(3 + (int)(Math.random() * 11)))+" years old"), c);
		
		//-------------------------------------------------------------------------------------------------		
		// Level
		c.gridx = 4;
		c.gridy = 2;
		
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy+=4;
		
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy+=3;

		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy+=5;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy+=4;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		c.gridy++;
		tab1.add(new JLabel(("Level "+Integer.toString(1 + (int)(Math.random() * 12)))), c);
		//-------------------------------------------------------------------------------------------------		
		// Separators
		c.insets = new Insets(0,0,0,0);
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 1;
	    c.gridwidth = 5;
		c.gridheight =1;
		c.gridx = 0;
		c.gridy = 1;
		for(int i = 1; i< 6;i++){
			JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
			sep.setPreferredSize(new Dimension(1,30));

			tab1.add(sep,c);
					
			c.gridy+=5;
		}
			
	}

	/**
	 * Fill tab levels.
	 *
	 * @param tab the tab
	 * @param c the c
	 */
	private void fillTabLevels(JPanel tab, GridBagConstraints c){
		c = new GridBagConstraints();
		c.insets = new Insets(0,10,0,10);
		c.gridwidth = 1;
		c.gridheight =1;
		c.gridx = 1;
		c.gridy = 0;
		tab.add(new JLabel("Level "),c);
		
        //-------------------------------------------------------------------------------------------------	
		//Level Combo Box
		Vector<String> m = new Vector<String>();
		
		for(int i=1;i<13;i++){
			m.add(Integer.toString(i));
		}
		JComboBox<String> levels = new JComboBox<String>(m);
		c.gridx = 2;
		tab.add(levels, c);
		
		//------------------------------------------------------------------------
		//Rank		
		c.gridx = 0;
		c.gridy = 3;
		for(int i =1;i<4;i++){
			c.gridy+=2;
			tab.add(new JLabel(Integer.toString(i)), c);
		}
		//------------------------------------------------------------------------
		//Headers
		c.gridx=1;
		c.gridy=3;
		tab.add(new JLabel("Friends"), c);
		c.gridx=0;
		tab.add(new JLabel("Rank"), c);
		c.gridx =3;
		tab.add(new JLabel("Child"), c);
		c.gridx = 4;
		tab.add(new JLabel("Age"), c);
		c.gridx=5;
		tab.add(new JLabel("Fastest Time"), c);
		//------------------------------------------------------------------------
		//Profile Pictures
		c.insets = new Insets(0,5,0,5);
		c.gridx = 1;
		c.gridy=5;
		c.gridheight =1;	
		c.ipady = 30;
		for(int i=1; i<4;i++){
			
			try	{
				Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/profilePictures/"+i+".jpg"));
				JLabel pic = new JLabel(new ImageIcon(getScaledImage(img, 55,55)));
				tab.add(pic, c);
			} catch (IOException e) {
				tab.add(new JLabel("Profile Picture"), c);
			}
			c.gridy+=2;
		}
		//------------------------------------------------------------------------
		//Friends Names
		c.gridx = 2;
		c.gridy=5;
		c.ipady = 0;
		tab.add(new JLabel("James Baron"), c);
		c.gridy+=2;
		tab.add(new JLabel("James Anderson"), c);
		c.gridy+=2;
		tab.add(new JLabel("Chuhan Frank"), c);
		//------------------------------------------------------------------------
		//Child Names
		c.gridx = 3;
		c.gridy=5;
		tab.add(new JLabel("Jim"), c);
		c.gridy+=2;
		tab.add(new JLabel("Lisa"), c);
		c.gridy+=2;
		tab.add(new JLabel("Leslie"), c);
		//------------------------------------------------------------------------
		//Ages
		c.gridx = 4;
		c.gridy=5;
		tab.add(new JLabel("8"), c);
		c.gridy+=2;
		tab.add(new JLabel("7"), c);
		c.gridy+=2;
		tab.add(new JLabel("9"), c);
		//------------------------------------------------------------------------
		//Fastest Times
		c.gridx = 5;
		c.gridy=5;
		tab.add(new JLabel("0:27"), c);
		c.gridy+=2;
		tab.add(new JLabel("0:35"), c);
		c.gridy+=2;
		tab.add(new JLabel("1:20"), c);
		//-------------------------------------------------------------------------------------------------		
		// Separators
		c.insets = new Insets(0,0,0,0);
	    c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		for(int i = 1; i<5;i++){
			JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
			sep.setPreferredSize(new Dimension(1,30));

			tab.add(sep,c);
					
			c.gridy+=2;
		}
			
	}
	
	/**
	 * Fill tab age.
	 *
	 * @param tab the tab
	 * @param c the c
	 */
	private void fillTabAge(JPanel tab, GridBagConstraints c){
		c = new GridBagConstraints();
		c.insets = new Insets(0,10,0,10);
		c.gridwidth = 1;
		c.gridheight =1;
		c.gridx = 1;
		c.gridy = 0;
		tab.add(new JLabel("Age "),c);
		
        //-------------------------------------------------------------------------------------------------	
		//Level Combo Box
		Vector<String> m = new Vector<String>();
		for(int i=3;i<14;i++){
			m.add(Integer.toString(i));
		}
		JComboBox<String> levels = new JComboBox<String>(m);
		c.gridx = 2;
		tab.add(levels, c);
		//------------------------------------------------------------------------
		//Rank		
		c.gridx = 0;
		c.gridy = 3;
		for(int i =1;i<4;i++){
			c.gridy+=2;
			tab.add(new JLabel(Integer.toString(i)), c);
		}
		//------------------------------------------------------------------------
		//Headers
		c.gridx=1;
		c.gridy=3;
		tab.add(new JLabel("Friends"), c);
		c.gridx=0;
		tab.add(new JLabel("Rank"), c);
		c.gridx =3;
		tab.add(new JLabel("Child"), c);
		c.gridx = 4;
		tab.add(new JLabel("Age"), c);
		c.gridx=5;
		tab.add(new JLabel("Fastest Time"), c);
		//------------------------------------------------------------------------
		//Profile Pictures
		c.insets = new Insets(0,5,0,5);
		c.gridx = 1;
		c.gridy=5;
		c.gridheight =1;	
		c.ipady = 30;
		for(int i=1; i<4;i++){
			
			try	{
				Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/profilePictures/"+i+".jpg"));
				JLabel pic = new JLabel(new ImageIcon(getScaledImage(img, 55,55)));
				tab.add(pic, c);
			} catch (IOException e) {
				tab.add(new JLabel("Profile Picture"), c);
			}
			c.gridy+=2;
		}
		//------------------------------------------------------------------------
		//Friends Names
		c.gridx = 2;
		c.gridy=5;
		c.ipady = 0;
		tab.add(new JLabel("James Baron"), c);
		c.gridy+=2;
		tab.add(new JLabel("James Anderson"), c);
		c.gridy+=2;
		tab.add(new JLabel("Chuhan Frank"), c);
		//------------------------------------------------------------------------
		//Child Names
		c.gridx = 3;
		c.gridy=5;
		tab.add(new JLabel("Jim"), c);
		c.gridy+=2;
		tab.add(new JLabel("Lisa"), c);
		c.gridy+=2;
		tab.add(new JLabel("Leslie"), c);
		//------------------------------------------------------------------------
		//Ages
		c.gridx = 4;
		c.gridy=5;
		tab.add(new JLabel("8"), c);
		c.gridy+=2;
		tab.add(new JLabel("7"), c);
		c.gridy+=2;
		tab.add(new JLabel("9"), c);
		//------------------------------------------------------------------------
		//Fastest Times
		c.gridx = 5;
		c.gridy=5;
		tab.add(new JLabel("0:27"), c);
		c.gridy+=2;
		tab.add(new JLabel("0:35"), c);
		c.gridy+=2;
		tab.add(new JLabel("1:20"), c);
		//-------------------------------------------------------------------------------------------------		
		// Separators
		c.insets = new Insets(0,0,0,0);
	    c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		for(int i = 1; i<5;i++){
			JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
			sep.setPreferredSize(new Dimension(1,30));

			tab.add(sep,c);
					
			c.gridy+=2;
		}
		
	}
// Resize ImageIcon
	/**
 * Gets the scaled image.
 *
 * @param srcImg the src img
 * @param w the w
 * @param h the h
 * @return the scaled image
 */
private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
}
