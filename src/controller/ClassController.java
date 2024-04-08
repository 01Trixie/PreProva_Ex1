package controller;

import java.util.concurrent.Semaphore;

public class ClassController extends Thread{
	Semaphore semaforo;
	private int ThreadId;
	
	public ClassController(int ThreadId, Semaphore semaforo){
		this.ThreadId = ThreadId;
		this.semaforo = semaforo;
	}
	public void run(){
		processoFcfs();
	}
	private void processoFcfs(){
	int cta = 0;
	
		while(cta < 1){
			cta+= 1;
			int duracao = (int) ((Math.random()* 5)+116);
			try{
				sleep(duracao);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("A Thread #" + ThreadId + "chegou");
			
			try {
				semaforo.acquire();
				saida();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
	private void saida() {
		System.out.println("A Thread " + ThreadId + " saiu."); 
	}

	
}