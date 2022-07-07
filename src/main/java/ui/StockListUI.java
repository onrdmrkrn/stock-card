package ui;

import dal.StockDal;
import interfaces.IUiInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StockListUI extends JDialog implements IUiInterface {
    public StockListUI(){
        initWindow();
    }

    @Override
    public void initWindow() {
        JPanel panel = initPanel();
        add(panel);
        setTitle("Stock Card");
        panel.setBorder(BorderFactory.createTitledBorder("Stock List:"));
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
        panel.setBorder(BorderFactory.createTitledBorder("LİST"));
        JPanel up = new JPanel(new GridLayout(4,2));

        JLabel idLabel = new JLabel("Stok Code:", JLabel.LEFT);
        up.add(idLabel);

        JTextField idField = new JTextField();
        up.add(idField);

        JList stockList = new JList();

        stockList.setListData(new StockDal().getAll().toArray());


        JScrollPane pane = new JScrollPane(stockList);
        pane.setBorder(BorderFactory.createTitledBorder("List Card"));
        stockList.setSelectedIndex(0);
        panel.add(up,BorderLayout.NORTH);
        panel.add(pane,BorderLayout.CENTER);




        idField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean tryParse;

                try{
                    Integer.parseInt(idField.getText());
                    tryParse = true;
                }
                catch (NumberFormatException numberFormatException){
                    tryParse = false;
                }

                if (tryParse != false){
                    stockList.setListData(new StockDal().GetById(Integer.parseInt(idField.getText())).toArray());
                    stockList.setSelectedIndex(0);
                }
                else {
                    stockList.setListData(new StockDal().getAll().toArray());
                }



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
