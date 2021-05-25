package westmarine.portal.common;

public enum Status {
    APPROVED ("Approved"),
    DECLINED ("Declined");

    public final String text;
    Status(String text) {
        this.text = text;
    }
}
