public class Smoke {
    public static void main(String[] args) {
        if (!"standalone".equals(System.getProperty("tddup.bridge.host"))) {
            throw new IllegalStateException("Standalone agent did not initialize");
        }
        System.out.println("TDDUP_SMOKE_MAIN_OK");
    }
}
