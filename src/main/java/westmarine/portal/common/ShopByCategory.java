package westmarine.portal.common;

public enum ShopByCategory {
    ANCHORDOCKING_ANCHORS ("anchors"),
    FISHING_FISHFINDERS   ("fishfinders"),
    WOMENS_JACKETS        ("women-s-jackets");

    public final String subpage;
    ShopByCategory(String subpage) {
        this.subpage = subpage;
    }
}
