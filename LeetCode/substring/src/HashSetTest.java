import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static final class Person {
        private String name = "";
        public Person(String n) {
            setName(n);
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = (name == null) ? "" : name;
        }

        @Override
        public int hashCode() {
            return name.length();
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.name.equals(((Person) obj).name);
        }
    }

    public static void main(String[] args) {
        // HashSet<int[]> set = new HashSet<>();
        // int[] zz = {1, 2};
        // int[] zzz = {1, 2};
        // int[] zzzz = new int[2];
        // zzzz[0] = 1;
        // zzzz[1] = 2;
        // boolean bz = zz.equals(zzz);
        // int hzz = zz.hashCode();
        // int hzzz = zzz.hashCode();
        // int hzzzz = zzzz.hashCode();
        // set.add(zz);
        // set.add(zzz);
        // set.add(zzzz);

        // HashSet<String> sets = new HashSet<>();
        // // String s1 = "aaa";
        // String s2 = new String("aaa");
        // String s3 = new String("aaa");
        // int hs2 = s2.hashCode();
        // int hs3 = s3.hashCode();
        // boolean bbb = s2 == s3;
        // // sets.add(s1);
        // sets.add(s2);
        // sets.add(s3);
        // String s4 = new String("aaa");
        // s4.intern();
        // sets.add(s4);
        
        Set<Person> persons = new HashSet<Person>();
        HashMap a;
        Person person = new Person("nowcoder");
        persons.add(person);
        person.setName("nowcodertest");
        boolean isContains = persons.contains(person);
        int size = persons.size();
        System.out.println("isContains=" + isContains);
        System.out.println("size=" + size);



    }
}
