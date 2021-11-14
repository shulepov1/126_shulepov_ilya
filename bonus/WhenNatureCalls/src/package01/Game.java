package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    Player player = new Player();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm, player);
    Story.SoundEffect se = new Story.SoundEffect();


    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {

        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();

    }
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start" : vm.titleToTown(); story.introduction(); se.setFile(story.clickSound); se.play(); break;
                case "c1" : story.selectPosition(nextPosition1); se.setFile(story.clickSound); se.play(); break;
                case "c2" : story.selectPosition(nextPosition2); se.setFile(story.clickSound); se.play(); break;
                case "c3" : story.selectPosition(nextPosition3); se.setFile(story.clickSound); se.play(); break;
                case "c4" : story.selectPosition(nextPosition4); se.setFile(story.clickSound); se.play(); break;

            }
        }
    }
}
