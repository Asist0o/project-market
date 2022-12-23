package market.config;

public enum  UrlServices {

    ADS_SERVICE("lb://MARKET-ADS"),
    AUTH_SERVICE("lb://MARKET-AUTHORIZATION"),
    CHAT_SERVICE("lb://MARKET-CHAT"),
    EMAIL_SERVICE("lb://MARKET-EMAIL"),
    NOTIFICATION_SERVICE("lb://MARKET-NOTIFICATION"),
    PAYMENT_SERVICE("lb://MARKET-PAYMENT"),
    PROFILE_SERVICE("lb://MARKET-PROFILES"),
    FILE_STORAGE_SERVICE("lb://MARKET-STORAGE");

    private final String url;

    UrlServices(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
