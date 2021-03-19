package view;

import java.util.concurrent.Semaphore;

import controller.Venda;

public class Principal {

	public static void main(String[] args) {
    Semaphore semaforo = new Semaphore(1);
	for (int i = 0; i < 300 ; i++) {
		Thread t = new Venda(semaforo);
		t.start();
	}	 

	}

}
