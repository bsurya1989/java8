package sample2;

public class ListenerDemo {
    public static void main(String args[]) {
        LongRunningTask longRunningTask = new LongRunningTask();
        longRunningTask.setOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete() {
                System.out.println("Yeah, the long running task has been completed!");
            }
        });

        System.out.println("Starting the long running task.");
        longRunningTask.run();
    }
}