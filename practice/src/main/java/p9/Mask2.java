package p9;

import java.util.concurrent.Callable;

public class Mask2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        return "线程二";
    }
}
