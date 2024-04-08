package view;

import java.util.concurrent.Semaphore;
import controller.ClassController;

public class Principal{
	public static void main(String [] args){
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int ThreadId = 0; ThreadId < 3; ThreadId++){
			Thread tFCFS = new ClassController(ThreadId, semaforo);
			tFCFS.start();
		}
	}
}