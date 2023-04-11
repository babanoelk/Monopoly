
public class Main {


    public static void main(String[] args) {
        Game game = new Game(6,2);
        //todo omnavngiv setup metoden, da der nu skal skelnes mellem player setup og board setup
        game.playerSetup();
        game.boardSetup();
        game.runGameLoop();
        //todo: lav en metode der loader felt data og instantierer Board
        //todo: fjern kaldene til runGameLoop og endgame fra Game, og placer dem her, så man kan se hele spillets livscyclus fra main
        //game.endGame();

    }
}