package sample2;

public class LongRunningTask implements Runnable {

    private OnCompleteListener onCompleteListener;

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5*1000); // sleep for 5 seconds and pretend to be working
            onCompleteListener.onComplete();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
