package collection.set.test;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
public class UniqueNamesTest2 {
    public static void main(String[] args) {

        Integer[] inputArr = {30, 20, 20, 10, 10}; // 코드 작성
        Set<Integer> set = new LinkedHashSet<Integer>();

        Collections.addAll(set, inputArr);
        for(Integer i : set) {
            System.out.println(i);
        }
    } }