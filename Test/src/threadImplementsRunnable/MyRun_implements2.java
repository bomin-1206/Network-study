package threadImplementsRunnable;

public class MyRun_implements2 implements Runnable {
	
	// �۾� ����
	public void run() {
		for(int i=0;i<500;i++) {
			System.out.printf("t2 Thread: %d \n",i);
		}
	}
}

