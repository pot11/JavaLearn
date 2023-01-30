package p9;

import java.util.concurrent.Callable;

public class Mask1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(400);
        return "线程一";
    }
}
