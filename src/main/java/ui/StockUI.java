package ui;


import com.toedter.calendar.JDateChooser;
import dal.StockDal;
import entities.Stock;
import interfaces.IUiInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.SimpleDateFormat;


import javax.swing.*;


public class StockUI extends JDialog implements IUiInterface {

	

	public StockUI() {
		initWindow();
	}

	@Override
	public void initWindow() {

		JPanel panel = initPanel();
		add(panel);
		setTitle("Stock Card");
		panel.setBorder(BorderFactory.createTitledBorder("Stock ADD:"));
		pack();
		setSize(800,500);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(12,6));


		JLabel idLabel = new JLabel("Stock Id:", JLabel.LEFT);
		panel.add(idLabel);

		JTextField idField = new JTextField();
		panel.add(idField);




		JLabel nameLabel = new JLabel("Stock Name: ", JLabel.LEFT);
		panel.add(nameLabel);
		JTextField fieldName = new JTextField(100);
		panel.add(fieldName);
		
		
		JLabel descriptionLabel = new JLabel("Stock Description: ", JLabel.LEFT);
		panel.add(descriptionLabel);


		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);


		JTextArea descriptionArea = new JTextArea();
		descriptionArea.add(scrollPane);
		panel.add(descriptionArea);


		JLabel unitLabel = new JLabel("Stock Sales Unit: ", JLabel.LEFT);
		panel.add(unitLabel);



		JComboBox unitBox = new JComboBox();

		panel.add(unitBox);
		unitBox.insertItemAt("---Please Choose Unit",0);
		unitBox.setSelectedIndex(0);
		unitBox.insertItemAt("Dolar",1);
		unitBox.insertItemAt("Lira",2);
		unitBox.insertItemAt("Euro",3);
		unitBox.insertItemAt("Sterlin",4);


		JLabel barcodeLabel = new JLabel("Barcode: ", JLabel.LEFT);
		panel.add(barcodeLabel);
		JTextField barcodeField = new JTextField();
		panel.add(barcodeField);

		
		JLabel kdvLabel = new JLabel("KDV: ", JLabel.LEFT);
		panel.add(kdvLabel);

		JComboBox <String> kdvBox = new JComboBox<String>();
		panel.add(kdvBox);
		kdvBox.insertItemAt("---Please Choose KDV--",0);
		kdvBox.insertItemAt("%9",1);
		kdvBox.insertItemAt("%18",2);
		kdvBox.insertItemAt("%27",3);

		kdvBox.setSelectedIndex(0);


		
		JLabel priceLabel = new JLabel("Price: ", JLabel.LEFT);
		panel.add(priceLabel);
		
		JTextField priceField = new JTextField();
		panel.add(priceField);

		JLabel typeLabel = new JLabel("Stock Type: ", JLabel.LEFT);
		panel.add(typeLabel);

		JComboBox typeBox = new JComboBox();
		panel.add(typeBox);

		typeBox.insertItemAt("--Please Choose Stock Type--",0);
		typeBox.insertItemAt("1",1);
		typeBox.insertItemAt("2",2);
		typeBox.insertItemAt("3",3);
		typeBox.insertItemAt("4",4);

		typeBox.setSelectedIndex(0);

		JLabel dateLabel = new JLabel("Choose Date: ",JLabel.LEFT);
		panel.add(dateLabel);
		final JDateChooser chooseDate = new JDateChooser();
		panel.add(chooseDate);
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		JButton findButton = new JButton("Find");
		panel.add(findButton);



		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Stock stock = new StockDal().find(Integer.parseInt(idField.getText()));

				String existskdv = String.valueOf(stock.getKdv());
				existskdv = existskdv.replace("%","");

				fieldName.setText(stock.getStockName());
				typeBox.setSelectedIndex(stock.getStockType());
				descriptionArea.setText(stock.getStockDescription());
				priceField.setText(String.valueOf(stock.getPrice()));
				barcodeField.setText(stock.getBarcode());
				chooseDate.setDate(stock.getCreatedDate());

				switch (existskdv){
					case "9.0":
						kdvBox.setSelectedIndex(1);
						break;

					case "18.0":
						kdvBox.setSelectedIndex(2);
						break;
					case "27.0":
						kdvBox.setSelectedIndex(3);

						break;
				}



				unitBox.setSelectedItem(stock.getUnit());


			}
		});

		JButton saveButton = new JButton("Save");
		panel.add(saveButton);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stock product = new Stock();
				String existskdv = String.valueOf(kdvBox.getSelectedItem());
				String existsType = String.valueOf(typeBox.getSelectedItem());
				existskdv = existskdv.replace("%","");

				String date = format.format(chooseDate.getDate());


				product.setStockName(fieldName.getText());
				product.setBarcode(barcodeField.getText());
				product.setKdv(Double.parseDouble(existskdv));
				product.setUnit(String.valueOf(unitBox.getSelectedItem()));
				product.setPrice(priceField.getColumns());
				product.setStockDescription(descriptionArea.getText());
				product.setStockType(Integer.parseInt(existsType));
				product.setPrice(Float.parseFloat((priceField.getText())));
				product.setCreatedDate(Date.valueOf(date));



				new StockDal().Insert(product);
				JOptionPane.showMessageDialog(null,product.getStockName()+" added.");



			}
		});

		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});


		return panel;
	}



	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}



}
