import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CasinoApplication extends Application {

    private CardDeck cardDeck = new CardDeck();
    private Hand dealer, player;
    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox dealerCards = new HBox(20);
    private HBox playerCards = new HBox(20);

    private Parent createContent() {
        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());

        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");

        HBox rootLayout = new HBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle leftBackground = new Rectangle(550, 560);
        leftBackground.setArcWidth(50);
        leftBackground.setHeight(50);
        leftBackground.setFill(Color.GREEN);
        Rectangle rightBackground = new Rectangle(230, 560);
        rightBackground.setArcWidth(50);
        rightBackground.setHeight(50);
        rightBackground.setFill(Color.ORANGE);

        // Left
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerScore, playerCards);

        //Right
        VBox rightVBox = new VBox(20);
        rightVBox.setAlignment(Pos.CENTER);

        final TextField bet = new TextField("BET");
        bet.setDisable(true);
        bet.setMaxWidth(50);
        Text money = new Text("MONEY");

        Button btnPlay = new Button("PLAY");
        Button btnHit = new Button("HIT");
        Button btnStand = new Button("STAND");

        HBox buttonsHBox = new HBox(15, btnHit, btnStand);
        buttonsHBox.setAlignment(Pos.CENTER);
        rightVBox.getChildren().addAll(bet, btnPlay, money, buttonsHBox);

        //ADD BOTH STACKS TO ROOT LAYOUT
        rootLayout.getChildren().addAll(new StackPane(leftBackground, leftVBox),
                new StackPane(rightBackground, rightVBox));

        //BIND PROPERTES
        btnPlay.disableProperty().bind(playable);
        btnHit.disableProperty().bind(playable.not());

        return root;
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BlackJack");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
