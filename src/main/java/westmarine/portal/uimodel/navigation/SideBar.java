package westmarine.portal.uimodel.navigation;

public enum SideBar {
    HOME               ("Home"),
    PAYMENT_CALCULATOR ("Payment Calculator"),
    NEW_APP            ("New App"),
    APPLICATIONS       ("Applications"),
    WEBAPPLY_SETUP     ("WebApply Setup"),
    RETURNS            ("Returns"),
    HELP               ("Help");

    public final String text;
    SideBar(String text) {
        this.text = text;
    }
}
