package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;
import dal.SqlSentence;
import dal.StockDal;
import entities.Stock;
import interfaces.IUiInterface;
import types.StockComplexType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.ImageObserver;


public class MainWindow extends JFrame implements IUiInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		initWindow();
	}

	@Override
	public void initWindow() {
		JPanel panel = initPanel();
		JMenuBar bar = initBar();
		
		add(panel);
		setJMenuBar(bar);
		setTitle("STOCK CARD APP");
		setVisible(true); 
		setSize(500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);




	}

	@Override
	public JMenuBar initBar() {
		return Utilities.initBar();
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JTabbedPane pane = initTabs();
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JTabbedPane initTabs() {

		JTabbedPane pane = new JTabbedPane();
		ImageIcon icon = new ImageIcon("icons/79739_cut_scissors_stock_icon (2).png");

		JPanel stockPanel = new JPanel(new BorderLayout());

		JPanel stockLeftPanel = new JPanel(new BorderLayout());
		JPanel stockLeftUpPanel = new JPanel(new GridLayout(6,2));
		JPanel stockLeftUnderPanel = new JPanel();

		stockLeftPanel.setBorder(BorderFactory.createTitledBorder("Stock Information"));
		Object [] stockColumn = {"Stock Code","Stock Name","Unit","Barcode","Stock Description","Created Date","Stock Type","KDV","Price"};
		DefaultTableModel model = new DefaultTableModel(stockColumn,0);
		JTable table = new JTable(model);
		JScrollPane stockTablePane = new JScrollPane(table);
		for (StockComplexType complexType: new SqlSentence().getAllSqlSentenceType()){
			model.addRow(complexType.getInfo());
		}



		JLabel stockProductNameLabel = new JLabel("Product Name:", JLabel.LEFT);
		stockLeftUpPanel.add(stockProductNameLabel);


		JComboBox stockProductNameBox = new JComboBox(new SqlSentence().getAllSqlSentenceType().toArray());
		stockLeftUpPanel.add(stockProductNameBox);


		JButton stockRefreshButton = new JButton("Refresh");
		stockLeftUpPanel.add(stockRefreshButton);

		stockRefreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int refresh = model.getRowCount();
				for (int i = 0; i <refresh ; i++) {
					model.removeRow(0);
				}


				for (StockComplexType type: new SqlSentence().getAllSqlSentenceType()){
					model.addRow(type.getInfo());
				}
			}
		});


		stockPanel.add(stockLeftPanel,BorderLayout.WEST);
		stockPanel.add(stockTablePane,BorderLayout.CENTER);
		stockLeftPanel.add(stockLeftUpPanel, BorderLayout.NORTH);
		stockLeftPanel.add(stockLeftUnderPanel,BorderLayout.SOUTH);

		pane.addTab("My First Swing Project Tex", icon, stockPanel,"Does Nothing");


		return pane;
	}

}
