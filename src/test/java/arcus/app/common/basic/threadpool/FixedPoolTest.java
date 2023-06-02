package arcus.app.common.basic.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedPoolTest {
    @Test
    void fixedPoolTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0 ; i < 10 ; i++) {
            executorService.execute(() -> {
                sleep(20);
            });
        }
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) executorService;
        int activeCount = threadPool.getActiveCount();
        System.out.println("activeCount = " + activeCount);
    }


    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
