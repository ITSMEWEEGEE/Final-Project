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
        mainFrame.setSize(500, 700);
        
        mainFrame.setLayout(new BorderLayout());
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JTextField inputField = new JTextField(20);
        mainFrame.add(listPanel, BorderLayout.CENTER);
        JPanel centralPanel = new JPanel();
       JPanel bottomPanel = new JPanel();
        bottomPanel.add(inputField);
        JButton AddButton = new JButton("Add Item");
        JButton EditButton = new JButton("Add Item");
        JButton RemoveButton = new JButton("Remove Item");
        JButton ClearButton = new JButton("Clear");
        bottomPanel.add(AddButton);
        bottomPanel.add(EditButton);
        bottomPanel.add(RemoveButton);
        bottomPanel.add(ClearButton);
        RemoveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });
        AddButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                myList.AddItems(text);
                refrestlist(listPanel, myList);
                inputField.setText("");
                listPanel.revalidate();
                listPanel.repaint();
            }
        });
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
           
        mainFrame.setVisible(true); // this must be the last statement
      
    }

    public static void refrestlist(JPanel listPanel, TheList myList){
        listPanel.removeAll();
    for (String item : myList.getlist()) {
        listPanel.add(new JCheckBox(item));
    }
    listPanel.revalidate();
    listPanel.repaint();
 }
}
