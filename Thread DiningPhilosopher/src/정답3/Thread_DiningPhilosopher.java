package ����3;

import java.util.concurrent.Semaphore;

public class Thread_DiningPhilosopher extends Thread{
	private static Semaphore eat = new Semaphore(1);
	int id; // ö���� id
    Semaphore lstick, rstick; // ����, ������ ������
    Thread_DiningPhilosopher(int id, Semaphore lstick, Semaphore rstick) {
        this.id = id;
        this.lstick = lstick;
        this.rstick = rstick;
    }
    public void run() {
        try {
            while(true) {
            	eat.acquire();
	                lstick.acquire(); 		// ���� ������
	                rstick.acquire(); 		// ������ ������
	            eat.release();
	                eating(); 				// �Ļ�
	                Thread.sleep(1);		// ���� �ݺ����� ���� �� ���� �ذ��(���� �ذ�� ��� ����)
	                rstick.release(); 		// ������ ��������
	                lstick.release(); 		// ���� ��������
                thinking(); 			// �����ϱ�
            }
        } catch (InterruptedException e) {}
    }
    
    void eating() {
        System.out.println("[" + id + "] �Ļ� ��");
    }
    
    void thinking() {
        System.out.println("[" + id + "] ���� ��");
    }
}