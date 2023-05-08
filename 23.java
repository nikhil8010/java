slip-23
1>
import java.util.Scanner;

public class VowelDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().toLowerCase(); // convert input to lowercase
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (isVowel(c)) {
                System.out.print(c);
                System.out.print(" "); // print space after vowel
                try {
                    Thread.sleep(3000); // pause for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}

2>
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class StudentNames {
public static void main(String[] args) {
ArrayList<String> studentNames = new ArrayList<>();
// Accept N student names through command line and add them to the
ArrayList
for (int i = 0; i < args.length; i++) {
studentNames.add(args[i]);
}
// Display the student names using Iterator interfaceSystem.out.println("Student names using Iterator:");
Iterator<String> iterator = studentNames.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
// Display the student names using ListIterator interface
System.out.println("\nStudent names using ListIterator:");
ListIterator<String> listIterator = studentNames.listIterator();
while (listIterator.hasNext()) {
System.out.println(listIterator.next());
}
}
}
