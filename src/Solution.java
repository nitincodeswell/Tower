import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
          public static ArrayList<Person> checkTallTower(List<Person> pers) {
                      if (pers == null) {
                                 return null;
                      }
                      return checkTallTower(pers, null);
           }
           private static ArrayList<Person> checkTallTower(List<Person> pers, Person bottom) {
                      int maximum = 0;
                      ArrayList<Person> maximumTower = null;
                      for (Person p : pers) {
                                 if (p.checkStand(bottom)) {
                                            ArrayList<Person> tower = checkTallTower(pers, p);
                                            int num = tower.size();
                                            if (num > maximum) {
                                                       maximum = num;
                                                       maximumTower = tower;
                                     }
                                 }
                      }
                      if (maximumTower == null)
                                 maximumTower = new ArrayList<Person>();
                      if (bottom != null)
                                 maximumTower.add(bottom);
                      return new ArrayList<Person>(maximumTower);
           }
           private static class Person {
                      int height, weight;
                      public Person(int h, int w) {
                                 height = h;
                                 weight = w;
                      }
                      private boolean checkStand(Person q) {
                                 return q == null || (height < q.height && weight < q.weight);
                      }
                      @Override
                      public String toString() {
                                 return "(" + height + ", " + weight + ")";
                      }
           }
           public static void main(String[] args) {
        	   		
        	   			
                      Person[] pers = { new Person(61, 101), new Person(65,100), new Person(70, 105), new Person(73, 98),
                                            new Person(75, 155), new Person(80, 205), new Person(80, 105), new Person(81, 195),
                                            new Person(81, 225) };
                      
                      List<Person> list = Arrays.asList(pers);
                      System.out.println(checkTallTower(list));
           }
}



