import java.util.Arrays;
import java.util.Comparator;


public class SortComparatorTest {
    public static void main(String[] args) {
        Integer[] a = {2,1,2,3,4,5};
        Arrays.sort(a, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });
        System.out.println(a);
    }
}

