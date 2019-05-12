package list_set_map;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

/**
 *
 * @author rockstar
 */
public class SetExample {
    public static void main(String args[]){
        Set set = new HashSet();
        set.add("Bernadine");
        set.add("Elizabeth");
        set.add("Clara");
        set.add("Elizabeth");
        set.add("Gene");
        System.out.println(set);
        Set sortedSet = new TreeSet(set);
        System.out.println(sortedSet);
    }
}
