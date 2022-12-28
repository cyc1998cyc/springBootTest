package chen.zhujie.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 陈宇超
 * 22:08
 */
public class LockTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<String,Object>();

        List<String> list = new ArrayList<String>();

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();

        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        Executors.newFixedThreadPool(10);

        ExecutorService executorService2 = new ThreadPoolExecutor(1, 2, 12, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executorService2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("chenyuchao");
            }
        });
        
    }
}
