package threadWithSemaphore;

public class Thread_SemaphoreMain { // Semaphore를 활용한 임계구역 설정

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread_WithSemaphore m1 = new Thread_WithSemaphore();
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		Thread t3 = new Thread(m1);
		
		
		t1.start();
		t2.start();
		t3.start();
	}

}