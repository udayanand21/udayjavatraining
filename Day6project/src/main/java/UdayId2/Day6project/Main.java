package UdayId2.Day6project;

import java.util.*;

public class Main {
    static HashSet<Employee> empset = new HashSet<>();

    static {
        empset.add(new Employee(123, "Uday", 89000));
        empset.add(new Employee(124, "Abhay", 45000));
        empset.add(new Employee(125, "Ajay", 5500));
        empset.add(new Employee(126, "Vijay", 77000));
        empset.add(new Employee(127, "Ritika", 87000));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. List");
            System.out.println("2. Add");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Find by ID");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int ch = nextIntSafe(sc);

            switch (ch) {
                case 1: list(); break;
                case 2: add(sc); break;
                case 3: update(sc); break;
                case 4: delete(sc); break;
                case 5: find(sc); break;
                case 0: System.out.println("Bye"); return;
                default: System.out.println("Invalid");
            }
        }
    }

    static void list() {
        List<Employee> list = new ArrayList<>(empset);
        list.sort(Comparator.comparingLong(Employee::getId));
        list.forEach(System.out::println);
    }

    static void add(Scanner sc) {
        System.out.print("Id: ");
        long id = nextLongSafe(sc);
        if (getById(id) != null) { System.out.println("Id exists"); return; }
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Salary: ");
        double sal = nextDoubleSafe(sc);
        empset.add(new Employee(id, name, sal));
        System.out.println("Added");
    }

    static void update(Scanner sc) {
        System.out.print("Id to update: ");
        long id = nextLongSafe(sc);
        Employee e = getById(id);
        if (e == null) { System.out.println("Not found"); return; }
        System.out.print("New name (- to keep): ");
        String name = sc.next();
        if (!name.equals("-")) e.setName(name);
        System.out.print("New salary (-1 to keep): ");
        double sal = nextDoubleSafe(sc);
        if (sal >= 0) e.setSalary(sal);
        System.out.println("Updated: " + e);
    }

    static void delete(Scanner sc) {
        System.out.print("Id to delete: ");
        long id = nextLongSafe(sc);
        Employee e = getById(id);
        if (e == null) { System.out.println("Not found"); return; }
        empset.remove(e);
        System.out.println("Deleted");
    }

    static void find(Scanner sc) {
        System.out.print("Id: ");
        long id = nextLongSafe(sc);
        Employee e = getById(id);
        if (e == null) System.out.println("Not found"); else System.out.println(e);
    }

    static Employee getById(long id) {
        for (Employee e : empset) if (e.getId() == id) return e;
        return null;
    }

    static int nextIntSafe(Scanner sc) {
        while (!sc.hasNextInt()) { sc.next(); System.out.print("Enter number: "); }
        return sc.nextInt();
    }
    static long nextLongSafe(Scanner sc) {
        while (!sc.hasNextLong()) { sc.next(); System.out.print("Enter number: "); }
        return sc.nextLong();
    }
    static double nextDoubleSafe(Scanner sc) {
        while (!sc.hasNextDouble()) { sc.next(); System.out.print("Enter number: "); }
        return sc.nextDouble();
    }
}
