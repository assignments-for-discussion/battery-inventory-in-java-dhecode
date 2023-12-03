package bunchbysoh;

public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();

        int ratedCapacity = 120;  

        HashMap<String, Integer> classificationCounts = new HashMap<>();

     
        for (int presentCapacity : presentCapacities) {
        
            double soh = (double) presentCapacity / ratedCapacity * 100;

            if (soh > 80 && soh <= 100) {
                classificationCounts.put("healthy", classificationCounts.getOrDefault("healthy", 0) + 1);
                System.out.println("The converion of rated capacity " +presentCapacity+" is "+soh+" and is healthy");
            } else if (soh >= 62 && soh <= 80) {
                classificationCounts.put("exchange", classificationCounts.getOrDefault("exchange", 0) + 1);
                System.out.println("The converion of rated capacity " +presentCapacity+" is "+soh+" and is exchange");
            } else if (soh < 62) {
                classificationCounts.put("failed", classificationCounts.getOrDefault("failed", 0) + 1);
                  System.out.println("The converion of rated capacity " +presentCapacity+" is "+soh+" and is failed");
            }
        }

        counts.healthy = classificationCounts.getOrDefault("healthy", 0);
        counts.exchange = classificationCounts.getOrDefault("exchange", 0);
        counts.failed = classificationCounts.getOrDefault("failed", 0);
        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);

        // Print the results 
        System.out.println("Healthy: " + counts.healthy);
        System.out.println("Exchange: " + counts.exchange);
        System.out.println("Failed: " + counts.failed);

        System.out.println("\nDone counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
