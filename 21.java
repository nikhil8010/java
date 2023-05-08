slip-21
1>
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class SubjectNames {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number of subjects: ");
int n = sc.nextInt();LinkedList<String> subjects = new LinkedList<String>();
System.out.println("Enter the subject names:");
for (int i = 0; i < n; i++) {
String subject = sc.next();
subjects.add(subject);
}
System.out.println("Subject names:");
Iterator<String> iterator = subjects.iterator();
while (iterator.hasNext()) {
String subject = iterator.next();
System.out.println(subject);
}
}
}

2>
package TYBCS;
import java.util.LinkedList;
import java.util.Queue;
public class setAc {
	private Queue<Integer> buffer = new LinkedList<>();
	private int maxSize = 5;
	
	public void producer() throws InterruptedException {
		
		int value = 0;
		while (true)
		{
			synchronized (this) {
				while (buffer.size() == maxSize) {
					wait();
					
				}
				System.out.println("Produce produced value:"+value);
				buffer.add(value++);
				notify();
			}
			Thread.sleep(1000);
		}
	}

public void consumer() throws InterruptedException {
	while (true) {
		synchronized (this)
		{
			while (buffer.isEmpty()) {
				wait();
			}
			int value = buffer.poll();
			System.out.println("Cnsumer consumed value :"+value);
			notify();
		}
		Thread.sleep(500);
	}
}
public static void main(String[] args)
{
	setAc pc=new setAc();
Thread producer=new Thread(() ->{
	try {
		pc.producer();
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
});
Thread consumer=new Thread(() ->{
	try {
		pc.consumer();
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
});
//start threds
producer.start();
consumer.start();
}
}

