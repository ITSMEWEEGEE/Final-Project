import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {
    
    
    public static void main(String[] args) throws Exception {
              /** Scanner scanner = new Scanner(System.in); */
       
       
         TheList List = new TheList();

        //* This is the main interface layout */
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
    
        bottomPanel.add(AddButton);
        bottomPanel.add(EditButton);
        bottomPanel.add(RemoveButton);
    
        
        AddButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                List.AddItems(text);
                refreshList(listPanel, List);
                inputField.setText("");
                listPanel.revalidate();
                listPanel.repaint();
            }
        });
        //* The Edit Button is editing the first item */
         EditButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Component[] components = listPanel.getComponents();
            for (int i = 0; i < components.length; i++){  
            
            JCheckBox box = (JCheckBox) components[i];
          if (box.isSelected()) {
                String newText = inputField.getText();
                List.editItem(i, newText);
                inputField.setText("");
                refreshList(listPanel, List);
                
                break;            
            }
    }}});

        RemoveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                Component[] components = listPanel.getComponents();
        for (int i = components.length - 1; i >= 0; i--) {
             JCheckBox box = (JCheckBox) components[i];
            if (box.isSelected()) {
        List.RemoveItems(i);}
            }
                refreshList(listPanel, List);    
        }
        });
        

        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
           
        mainFrame.setVisible(true); // this must be the last statement
      
    }

    public static void refreshList(JPanel listPanel, TheList List){
        listPanel.removeAll();
    for (String item : List.getlist()) {
        listPanel.add(new JCheckBox(item));
    }
    listPanel.revalidate();
    listPanel.repaint();
 }
}
