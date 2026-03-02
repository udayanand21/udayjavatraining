package UdayId2.Day6project;
import java.util.*;
public class DemoMap {
	public static void main (String[]args) {
		HashMap<Integer,String> hmap = new HashMap<>();
		hmap.put(1, "Uday");
		hmap.put(2, "Rtika");
		hmap.put(3, "Krishica");
		hmap.put(4, "Aryan");
		System.out.println(hmap);
		for(int key:hmap.keySet()) {
			System.out.println(key);
		}
		for(String s:hmap.values()) {
			System.out.println(s);
		}
	}
}
