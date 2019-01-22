package com.wfs;

import com.wfs.concurrent.Semaphore;

public class SemphoreTest {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2, true);

		for (int i = 0; i <3; i++) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t1.start();
		}
		for (int i = 0; i < 2; i++) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					semaphore.release();
				}
			});
			t1.start();
		}

	}
}
