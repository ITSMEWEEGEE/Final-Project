import java.util.ArrayList;

public class TheList {
     private ArrayList<String> list = new ArrayList<>();
      
     public void AddItems(String text) {
        if (text != null && !text.trim().isEmpty()) {
        list.add(text);
    }
}
    
    public void RemoveItems(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }
    
    public void editItem(int index, String newText){
        list.set(index, newText);
    }
    public void clearAll(){
    }
     public ArrayList<String> getlist() {
        return list;
    }
    
}
