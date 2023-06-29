public class DiscountRate {
    private static final double PREMIUM_SERVICE_DISCOUNT = 0.2;
    private static final double GOLD_SERVICE_DISCOUNT = 0.15;
    private static final double SILVER_SERVICE_DISCOUNT = 0.1;
    private static final double PRODUCT_DISCOUNT = 0.1;

    public static double getServiceDiscountRate(String memberType) {
        switch (memberType.toLowerCase()) {
            case "premium":
                return PREMIUM_SERVICE_DISCOUNT;
            case "gold":
                return GOLD_SERVICE_DISCOUNT;
            case "silver":
                return SILVER_SERVICE_DISCOUNT;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate() {
        return PRODUCT_DISCOUNT;
    }
}
