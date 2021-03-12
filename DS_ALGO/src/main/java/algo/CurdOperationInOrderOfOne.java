import java.util.*;
public class MyClass {
    List<Integer> items;
   static  Map<Integer,Integer> hash;
    
    MyClass(){
        items = new ArrayList<>();
        hash = new HashMap<>();
    }
    
    void add(int x){
      if(hash.get(x) != null){
          return;
      }
      items.add(x);
      hash.put(x,items.size()-1);
    }
    
    void remove(int x){
      Integer index = hash.get(x);
      if(index == null){
            return;
      }
     hash.remove(x);
     Collections.swap(items,index, items.size()-1);
     items.remove(items.size()-1);
     hash.put(items.get(items.size()-1),index);    
  }
    
   Integer search(int x){
       return hash.get(x);
   }
   
   Integer getRandom(){
       Random r = new Random();
       int index = r.nextInt(items.size());
      return items.get(index);
   }
    
    
    public static void main(String args[]) {
        MyClass ds = new MyClass(); 
        ds.add(10); 
        ds.add(20); 
        ds.add(30); 
        ds.add(40); 
        System.out.println(ds.search(20)); 
        ds.remove(20); 
        ds.add(50); 
        System.out.println(ds.search(20)); 
    }
}
