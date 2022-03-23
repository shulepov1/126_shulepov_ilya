package GameCore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Game {
    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    Player player = new Player();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm, player);
    Story.SoundEffect se = new Story.SoundEffect();
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public void runGame(){
        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start" -> {
                    vm.titleToTown();
                    story.introduction();
                    se.setFile(story.clickSound);
                    se.play();
                }
                case "c1" -> {
                    try {
                        story.selectPosition(nextPosition1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    se.setFile(story.clickSound);
                    se.play();
                }
                case "c2" -> {
                    try {
                        story.selectPosition(nextPosition2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    se.setFile(story.clickSound);
                    se.play();
                }
                case "c3" -> {
                    try {
                        story.selectPosition(nextPosition3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    se.setFile(story.clickSound);
                    se.play();
                }
                case "c4" -> {
                    try {
                        story.selectPosition(nextPosition4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    se.setFile(story.clickSound);
                    se.play();
                }
            }
        }
    }
}
