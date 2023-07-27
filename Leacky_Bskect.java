import java.util.concurrent.TimeUnit;

public class LeakyBucket {

    private int capacity; // Maximum bucket size
    private int rate; // Tokens added per second
    private long lastUpdateTime; // Time when the bucket was last updated
    private double tokens; // Current number of tokens in the bucket

    public LeakyBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.lastUpdateTime = System.nanoTime();
        this.tokens = 0.0;
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.nanoTime();
        // Calculate the time elapsed since the last update
        double elapsedTime = (currentTime - lastUpdateTime) / 1_000_000_000.0;
        // Add new tokens to the bucket based on the rate and elapsed time
        tokens = Math.min(capacity, tokens + (elapsedTime * rate));
        lastUpdateTime = currentTime;

        if (tokens >= 1.0) {
            // If there are enough tokens for the request, consume one token
            tokens -= 1.0;
            return true;
        } else {
            // Not enough tokens in the bucket, request is rejected
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        LeakyBucket bucket = new LeakyBucket(10, 2); // Capacity: 10 tokens, Rate: 2 tokens per second

        // Simulate requests
        for (int i = 1; i <= 15; i++) {
            System.out.println("Request " + i + " allowed? " + bucket.allowRequest());
            try {
                TimeUnit.SECONDS.sleep(1); // Sleep for 1 second between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
