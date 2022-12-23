package market.model;

public enum MailLanguages {

    RU("RU"), EN("EN");

    private final String language;

    MailLanguages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
