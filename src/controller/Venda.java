package controller;

import java.util.concurrent.Semaphore;

public class Venda extends Thread{
	
	private Semaphore semaforo;
	private static int ingresso = 100;
	
	public Venda(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		login();
		compra();
		try {
			semaforo.acquire();
			validacao();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

	private void login() {
		int tempo = (int) ((Math.random()*1951)+50);
		if (tempo > 1000) {
			System.out.println(getId()+" timeout: tempo esgotado. Você não poderá efetuar a compra");
		}
	}

	private void compra() {
		int tempo = (int) ((Math.random()*2001)+1000);
		if (tempo > 2500) {
			System.out.println(getId()+" timeout: tempo esgotado. Você não poderá efetuar a compra");
		}
	}

	private void validacao() {
		int compra = (int) ((Math.random()*4)+1);
		if(compra<ingresso) {
			ingresso -= compra;
			System.out.println(getId()+" compra efetuada com sucesso. Foi(ram) comprado(s) "+compra+" ingresso(s)");
			System.out.println("Ainda tem "+ingresso+" ingressos disponíveis");
		}else {
			System.out.println("quantidade indisponível");
		}
	}
	
	
}
