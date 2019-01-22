package com.wfs;

import com.wfs.concurrent.LinkedBlockingQueue;
import com.wfs.util.BlockingQueue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue =new LinkedBlockingQueue<>();

        for(int i=0;i<2;i++){
            Thread t1=new Thread(new Runnable() {
                @Override
                public void run() {
                    blockingQueue.offer("A");
                }
            });
            t1.start();
        }
        
        for(int i=0;i<2;i++){
            Thread t1=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
						blockingQueue.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            });
            t1.start();
        }
    }


}
