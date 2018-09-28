import javafx.scene.image.Image;

public enum Suit {

    HEARTS, DIAMONDS, CLUBS, SPADES;

    final Image image;

    Suit() {
        this.image = new Image(Card.class.getResourceAsStream("images".concat(name().toLowerCase())
                .concat(".png")), 32, 32, true, true);
    }
}
