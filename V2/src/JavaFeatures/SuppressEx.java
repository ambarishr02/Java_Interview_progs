package JavaFeatures;

public class SuppressEx {
    

        public static void main(String[] args) {
            try (ResourceA resourceA = new ResourceA(); ResourceB resourceB = new ResourceB()) {
                // Code that may throw an exception
                throw new Exception("Exception in try block");
            } catch (Exception e) {
                System.out.println("Caught exception: " + e.getMessage());
    
                // Accessing suppressed exceptions
                Throwable[] suppressedExceptions = e.getSuppressed();
                for (Throwable suppressed : suppressedExceptions) {
                    System.out.println("Suppressed exception: " + suppressed.getMessage());
                }
            }
        }
    
        static class ResourceA implements AutoCloseable {
            @Override
            public void close() throws Exception {
                throw new Exception("Exception in closing ResourceA");
            }
        }
    
        static class ResourceB implements AutoCloseable {
            @Override
            public void close() throws Exception {
                throw new Exception("Exception in closing ResourceB");
            }
        }
}
    

