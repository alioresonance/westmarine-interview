package westmarine.portal.common;

public enum Expected {
    SUCCESS ("Thank you for your interest in enrolling with Allegro Credit. We have received your information. " +
            "One of our Account Success Team Members will be contacting you shortly."),
    FAILED  (""),
    ERROR   ("");

    public final String message;

    Expected(String message) {
        this.message = message;
    }
}
