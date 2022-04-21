package worker;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (errorCallback.onError(Integer.toString(i))) {
                System.out.println("Task is Err");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }

}
