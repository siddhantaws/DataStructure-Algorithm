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
    }


}
