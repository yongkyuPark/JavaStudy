package collection.compare.test;

public enum Suit {
    SPADE("♠"),
    HEART("♥"),
    DIAMOND("\uDBFF\uDC00"),
    CLUB("♣");


    private String icon;

    Suit(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
