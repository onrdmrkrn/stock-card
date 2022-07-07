package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static javax.swing.JMenu.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Utilities {
	
	public static JMenuBar initBar() {
		
		JMenuBar bar = new JMenuBar();
		bar.add(productAttributes());
		bar.add(fileMenuAttributes());
		return bar;
		
	}
	
	public static JMenu productAttributes() {
	
		JMenu productUi = new JMenu("Stock Card");
		JMenuItem productAdd = new JMenuItem("Add Card");
		productUi.add(productAdd);


		productUi.addSeparator();
		
		productAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new StockUI();
						
					}
				});
				
			}
		});
		
		
		JMenuItem productFind = new JMenuItem("List Card");
		productUi.add(productFind);
		productUi.addSeparator();
		productFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new StockListUI();
					}
				});
			}

		});

		JMenuItem productUpdate = new JMenuItem("Update Card");
		productUi.add(productUpdate);
		productUi.addSeparator();
		productUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StockUpdateUI();
			}
		});

		JMenuItem productDelete = new JMenuItem("Delete Card");
		productUi.add(productDelete);
		productDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StockDeleteUI();
			}
		});

		return productUi;



		
	}
	
	public static JMenu fileMenuAttributes() {
		JMenu fileUi = new JMenu("File");

		JMenuItem quit =  new JMenuItem("Quit");
		fileUi.add(quit);

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return fileUi;
	}

}
