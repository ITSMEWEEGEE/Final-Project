import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class App extends JFrame {
    
    
    public static void main(String[] args) throws Exception {
              /** Scanner scanner = new Scanner(System.in); */
       
       
         TheList myList = new TheList();

        
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("To Do List");
        mainFrame.setSize(700, 790);
        
        mainFrame.setLayout(new BorderLayout());
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JTextField inputField = new JTextField(20);
        mainFrame.add(listPanel, BorderLayout.CENTER);
        JPanel centralPanel = new JPanel();
       JPanel bottomPanel = new JPanel();
        bottomPanel.add(inputField);
        JButton AddButton = new JButton("Add Item");
        JButton EditButton = new JButton("Edit Item");
        JButton RemoveButton = new JButton("Remove Item");
        JButton ClearButton = new JButton("Clear");
        bottomPanel.add(AddButton);
        bottomPanel.add(EditButton);
        bottomPanel.add(RemoveButton);
        bottomPanel.add(ClearButton);
        
        AddButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                myList.AddItems(text);
                refreshList(listPanel, myList);
                inputField.setText("");
                listPanel.revalidate();
                listPanel.repaint();
            }
        });
         EditButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            refreshList(listPanel, myList);            

    }});

        RemoveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                Component[] components = listPanel.getComponents();
        for (int i = components.length - 1; i >= 0; i--) {
             JCheckBox box = (JCheckBox) components[i];
            if (box.isSelected()) {
        myList.RemoveItems(i);}
            }
                refreshList(listPanel, myList);    
        }
        });
         ClearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }});

        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
           
        mainFrame.setVisible(true); // this must be the last statement
      
    }

    public static void refreshList(JPanel listPanel, TheList myList){
        listPanel.removeAll();
    for (String item : myList.getlist()) {
        listPanel.add(new JCheckBox(item));
    }
    listPanel.revalidate();
    listPanel.repaint();
 }
}
