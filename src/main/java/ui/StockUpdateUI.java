package ui;

import com.toedter.calendar.JDateChooser;
import dal.StockDal;
import entities.Stock;
import interfaces.IUiInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class StockUpdateUI extends JDialog implements IUiInterface {

    public StockUpdateUI(){
        initWindow();

    }
    @Override
    public void initWindow() {
        JPanel panel = initPanel();
        add(panel);
        setTitle("Stock Card");
        panel.setBorder(BorderFactory.createTitledBorder("Stock Update:"));
        pack();
        setSize(800,500);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Update"));
        JPanel up = new JPanel(new GridLayout(12,5));

        panel.add(up);

        JLabel idLabel = new JLabel("Stock Code", JLabel.LEFT);
        up.add(idLabel);
        JTextField idField = new JTextField();
        up.add(idField);

        JLabel nameLabel = new JLabel("Stok Name: ",JLabel.LEFT);
        up.add(nameLabel);
        JTextField nameField = new JTextField();
        up.add(nameField);

        JLabel typeLabel = new JLabel("Stock Type: ",JLabel.LEFT);
        up.add(typeLabel);

        JComboBox typeBox = new JComboBox();


        up.add(typeBox);
        typeBox.insertItemAt("--Please Choose Stock Type--",0);
        typeBox.setSelectedItem(0);

        typeBox.insertItemAt("1",1);
        typeBox.insertItemAt("2",2);
        typeBox.insertItemAt("3",3);
        typeBox.insertItemAt("4",4);

        JLabel unitLabel = new JLabel("Stock Sales Unit: ", JLabel.LEFT);
        up.add(unitLabel);

        JComboBox unitBox = new JComboBox();
        up.add(unitBox);
        unitBox.insertItemAt("---Please Choose Unit",0);
        unitBox.setSelectedIndex(0);
        unitBox.insertItemAt("Dolar",1);
        unitBox.insertItemAt("Lira",2);
        unitBox.insertItemAt("Euro",3);
        unitBox.insertItemAt("Sterlin",4);


        JLabel descriptionLabel = new JLabel("Stok Description: ", JLabel.LEFT);
        up.add(descriptionLabel);

        JTextArea descriptionArea = new JTextArea();
        up.add(descriptionArea);

        JLabel priceLabel = new JLabel("Price:",JLabel.LEFT);
        up.add(priceLabel);

        JTextField priceField = new JTextField();
        up.add(priceField);

        JLabel barcodeLabel = new JLabel("Barcode: ", JLabel.LEFT);
        up.add(barcodeLabel);
        JTextField barcodeField = new JTextField();
        up.add(barcodeField);

        JLabel kdvLabel = new JLabel("KDV: ", JLabel.LEFT);
        up.add(kdvLabel);

        JComboBox <String> kdvBox = new JComboBox<String>();
        up.add(kdvBox);

        kdvBox.insertItemAt("---Please Choose KDV--",0);
        kdvBox.insertItemAt("%9",1);
        kdvBox.insertItemAt("%18",2);
        kdvBox.insertItemAt("%27",3);

        JLabel createdateLabel = new JLabel("Choose Date: ",JLabel.LEFT);
        up.add(createdateLabel);
        final JDateChooser chooseDate = new JDateChooser();
        up.add(chooseDate);






        JButton findButton = new JButton("Find");
        up.add(findButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stock stock = new StockDal().find(Integer.parseInt(idField.getText()));
                String existskdv = String.valueOf(stock.getKdv());
                existskdv = existskdv.replace("%","");

                nameField.setText(stock.getStockName());
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



        JButton updateButton= new JButton("Update");
        up.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Stock stock = new Stock();
                String existsType = String.valueOf(typeBox.getSelectedItem());
                String existskdv = String.valueOf(kdvBox.getSelectedItem());
                existskdv = existskdv.replace("%","");

                stock.setStockId(Integer.parseInt(idField.getText()));
                stock.setStockName(nameField.getText());
                stock.setStockDescription(descriptionArea.getText());
                stock.setPrice(Float.parseFloat(priceField.getText()));
                stock.setBarcode(barcodeField.getText());
                stock.setUnit(String.valueOf(unitBox.getSelectedItem()));
                stock.setKdv(Double.parseDouble(existskdv));

                stock.setStockType(Integer.parseInt(existsType));


                new StockDal().Update(stock);
                JOptionPane.showMessageDialog(null,stock.getStockName()+" updated.");

            }
        });
        JButton cancelButton = new JButton("Cancel");
        up.add(cancelButton);

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
        return null;
    }
}
