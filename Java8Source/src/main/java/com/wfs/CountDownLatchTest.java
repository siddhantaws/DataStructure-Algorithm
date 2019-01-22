package com.wfs;

import com.wfs.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(2);

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("await1");
					countDownLatch.await();
					System.out.println("await");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		t2.start();
		
		for (int i = 0; i < 2; i++) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					countDownLatch.countDown();
					System.out.println("countDown");
				}
			});
			t1.start();

		}
		
	}
}