package westmarine.portal.common;

public enum Protection {
    YEAR_1 ("1 Year"),
    YEAR_2 ("2 Year");

    public final String type;
    Protection(String type) {
        this.type = type;
    }
}
