import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card extends Parent {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 140;

    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle cardBackground = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        cardBackground.setArcWidth(20);
        cardBackground.setArcHeight(20);
        cardBackground.setFill(Color.WHITE);

        Text text1 = new Text(rank.displayName());
        text1.setFont(Font.font(18));
        text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);

        Text text2 = new Text(text1.getText());
        text2.setFont(Font.font(18));
        text2.setX(10);
        text2.setY(CARD_HEIGHT - 10);

        ImageView imageView = new ImageView(suit.image);
        imageView.setRotate(180);
        imageView.setX(CARD_WIDTH - 32);
        imageView.setY(CARD_HEIGHT - 32);

        getChildren().addAll(cardBackground, new ImageView(
                suit.image), imageView, text1, text2);
    }

    @Override
    public String toString() {
        return rank.toString() + "of " + suit.toString();
    }


}
