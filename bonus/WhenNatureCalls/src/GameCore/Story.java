package GameCore;

import Monsters.*;
import Weapons.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

public class Story {
    SoundEffect se = new SoundEffect();

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player;
    SuperMonster monster = new SuperMonster();
    int silverRing;
    int wagonPotion;
    int knightCloak;
    int enterTown;
    int hanging;
    int hangingChoice;
    int checkFountain;
    int whaleTreasure;
    int statueEvent;
    int whaleCall;
    int paddle;
    int witch;
    int fountainEvent;

    String clickSound = ".//res//click.wav";
    String applause = ".//res//applause.wav";
    public Story(Game g, UI userInterface, VisibilityManager vManager, Player player1) {

        game = g;
        ui = userInterface;
        vm = vManager;
        player = player1;
    }
    public static class SoundEffect{
        Clip clip;

        public void setFile(String soundFileName){
            try{
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            catch (Exception e){
            }
        }

        public void play(){
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void defaultSetup() {
        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Weapon_Knife();
        /*
        try {
            player.currentWeapon.setWeapon("Нож");
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        ui.weaponNameLabel.setText(player.currentWeapon.getName());

        player.coin = 0;
        ui.coinNameLabel.setText("" + player.coin);

        silverRing = 0;
        wagonPotion = 0;
        knightCloak = 0;
        enterTown = 0;
        hanging = 0;
        hangingChoice = 0;
        checkFountain = 0;
        whaleTreasure = 0;
        statueEvent = 0;
        whaleCall = 0;
        paddle = 0;
        witch = 0;
        fountainEvent = 0;
    }
    public void selectPosition(String nextPosition) throws IOException {

        switch (nextPosition) {
            case "townGate" : townGate(); break;
            case "talkGuard" : talkGuard(); break;
            case "attackGuard" : attackGuard(); break;
            case "crossRoad" : crossRoad(); break;
            case "fight" : fight(); break;
            case "playerAttack" : playerAttack(); break;
            case "monsterAttack1" : monsterAttack1(); break;
            case "monsterAttack2" : monsterAttack2(); break;
            case "monsterAttack3" : monsterAttack3(); break;
            case "lose" : lose(); break;
            case "toTitle" : toTitle(); break;
            case "river" : river(); break;
            case "fishing" : fishing(); break;
            case "wagon" : wagon(); break;
            case "wagonSearch" : wagonSearch(); break;
            case "wagonPotion" : wagonPotion(); break;
            case "swamp" : swamp(); break;
            case "swampKnight" : swampKnight(); break;
            case "swampMinusHP" : swampMinusHP(); break;
            case "winKnight" : winKnight(); break;
            case "town" : town(); break;
            case "hangerHelped" : hangerHelped(); break;
            case "hangerNotHelped" :hangerNotHelped(); break;
            case "square" : square(); break;
            case "castleStairs" : castleStairs(); break;
            case "talkCastleGuard" : talkCastleGuard(); break;
            case "attackCastleGuard" : attackCastleGuard(); break;
            case "whale" : whale(); break;
            case "whaleLeft" : whaleLeft(); break;
            case "whaleForward" : whaleForward(); break;
            case "whaleRight" : whaleRight(); break;
            case "winSamurai" : winSamurai(); break;
            case "richBlock" : richBlock(); break;
            case "woodworker": woodworker(); break;
            case "talkWoodworker": talkWoodworker(); break;
            case "blacksmithArea" : blacksmithArea(); break;
            case "blacksmith" : blacksmith(); break;
            case "weaponShop" : weaponShop(); break;
            case "shield" : shield(); break;
            case "hammer" : hammer(); break;
            case "hammerOk" : hammerOk(); break;
            case "rapier" : rapier(); break;
            case "rapierOk" :rapierOk(); break;
            case "monument" : monument(); break;
            case "monumentKing" : monumentKing(); break;
            case "churchArea" : churchArea(); break;
            case "winWitch" : winWitch(); break;
            case "mansion" : mansion(); break;
            case "fountainDoNothing" : fountainDoNothing(); break;
            case "fountainHostage" : fountainHostage(); break;
            case "tavernArea" : tavernArea(); break;
            case "tavern" : tavern(); break;
            case "channels" : channels(); break;
            case "channelsArea" : channelsArea(); break;
            case "channelsDenied" : channelsDenied(); break;
            case "channelsLeft" : channelsLeft(); break;
            case "channelsRight" : channelsRight(); break;
            case "winRat" : winRat(); break;
            case "castle" : castle(); break;
            case "endingWin" : endingWin(); break;
            case "endingLose" : endingLose(); break;
            case "island" : island(); break;
            case "simon" : simon(); break;
        }
    }
    public void introduction() {
        ui.mainTextArea.setText("Вы пробуждаетесь от звука проехавшей мимо повозки. Вы открываете глаза, ваша голова кружится. Вы пытаетесь вспомнить хоть что-то, но в голове полный мрак." +
                " Через минуту неподалёку раздаётся сильный грохот, будто у тележки отвалилось колесо.");
        ui.choice1.setText("Встать и осмотреться");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void crossRoad(){
        ui.mainTextArea.setText("Рядом с вами деревянный знак со стрелками. Он указывает на части света.");
        ui.choice1.setText("Пойти на север");
        ui.choice2.setText("Пойти на восток");
        ui.choice3.setText("Пойти на запад");
        ui.choice4.setText("Пойти на юг");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "river";
        game.nextPosition3 = "swamp";
        game.nextPosition4 = "wagon";
    }
    public void townGate() {
        ui.mainTextArea.setText("Вы стоите у ворот в город. Перед вами стражник.");
        ui.choice1.setText("Поговорить");
        ui.choice2.setText("Атаковать");
        ui.choice3.setText("Уйти");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }
    public void talkGuard() {
        if (knightCloak == 0) {
            ui.mainTextArea.setText("Стражник: Приветствую, Странник. Прости, но я не могу пропустить тебя в город.");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (knightCloak == 1) {
            if (enterTown == 0) {
                ui.mainTextArea.setText("О, почему твой плащ весь в крови. И где твои доспехи?! Проходи в город и зайди к нашему Кузнецу - он тебя подлатает.");
                ui.choice1.setText("Войти в город");
                ui.choice2.setText("Вернуться");
                ui.choice3.setText("");
                ui.choice4.setText("");
                enterTown = 1;
            }
            else if (enterTown == 1) {
                ui.mainTextArea.setText("Да, проходи. Я тебя помню");
                ui.choice1.setText("Войти в город");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("");
            }
            game.nextPosition1 = "town";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void attackGuard(){
        ui.mainTextArea.setText("Стражник: Не глупи.\nСтражник слишком силён.\n\nВы получили 3 damage");
        player.hp = player.hp - 3;
        //если есть шанс умереть:
        if (player.hp < 1) {
            lose();
            player.hp = 0;
            ui.hpNumberLabel.setText("" + player.hp);
        }
        else {
            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
            ui.hpNumberLabel.setText("" + player.hp);
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
        }
    }
    public void river() {
        ui.mainTextArea.setText("Перед вами широкая бурная река. На каменистом берегу привязана лодка, но если вы попытаетесь переплыть, вас снесёт течением в неизвестность. " +
                "Вдали на горизонте виднеется другой берег, к нему причалена странное деревянное судно, издалека вы замечаете на нем горящие красные бумажные фонарики. Возле той лодки" +
                " никого нет. На вашем же берегу вы замечаете сломанную удочку.");
        if (whaleCall == 0 && paddle == 0) {
            ui.choice1.setText("Закинуть удочку");
            ui.choice2.setText("Вернуться обратно");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "fishing";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (whaleCall == 1 && paddle == 0) {
            ui.choice1.setText("Закинуть удочку");
            ui.choice2.setText("Вернуться обратно");
            ui.choice3.setText("Позвать кита");
            ui.choice4.setText("");

            game.nextPosition1 = "fishing";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "whale";
            game.nextPosition4 = "";
        }
        if (whaleCall == 0 && paddle == 1) {
            ui.choice1.setText("Закинуть удочку");
            ui.choice2.setText("Вернуться обратно");
            ui.choice3.setText("Переплыть реку");
            ui.choice4.setText("");

            game.nextPosition1 = "fishing";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "island";
            game.nextPosition4 = "";
        }
        else if (whaleCall == 1 && paddle == 1) {
            ui.choice1.setText("Закинуть удочку");
            ui.choice2.setText("Вернуться обратно");
            ui.choice3.setText("Позвать кита");
            ui.choice4.setText("Переплыть реку");

            game.nextPosition1 = "fishing";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "whale";
            game.nextPosition4 = "island";
        }
    }
    public void island(){
        ui.mainTextArea.setText("Вы переплывает остров и находите на другом берегу японскую лодку. Пройдя вглубь острова вы замечаете человека, ковыряющегося в каком-то механизме.");
        ui.choice1.setText("Подойти поближе");
        ui.choice2.setText("Вернуться на тот берег");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "simon";
        game.nextPosition2 = "river";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void simon(){
        ui.mainTextArea.setText("Незнакомец: Слушай, ты не видел нигде моего товарища? Он был одет в кимоно, ты бы его сразу узнал? Ну да ладно. Мы очутились на этом острове 20 лет назад, своего напарника" +
                "я не видел уже лет 15. Ну да ладно, думаю ему это больше не понадобится, возмьи в качестве подарка.\n\n(За обнаружение этого места вы получаете 100 HP и новое оружие!)");
        player.hp = player.hp + 100;
        ui.hpNumberLabel.setText(""+player.hp);
        try {
            player.currentWeapon.setWeapon("Вилка");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        ui.choice1.setText("Вернуться на тот берег");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "river";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void fishing() {
        if (player.hp < 50) {
            int i = new java.util.Random().nextInt(100);
            if (i > 0 && i < 30) {
                ui.mainTextArea.setText("К вашему поплавку приближается след от плавника рыбы, он становится все быстрее и быстрее. В нужный момент вы вытаскиваете удочку - но увы: мимо!");
                ui.choice1.setText("Закинуть удочку ещё раз");
                ui.choice2.setText("Бросить рыбалку");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "fishing";
                game.nextPosition2 = "river";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else if (i > 30 && i < 60) {
                ui.mainTextArea.setText("Рыба успешно клюёт и уже когда вы достаете удочку с ней из воды - подлетает огромная чайка, хватает вашу добычу и улетает!");
                ui.choice1.setText("Закинуть удочку ещё раз");
                ui.choice2.setText("Бросить рыбалку");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "fishing";
                game.nextPosition2 = "river";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else if (i > 60 && i < 90) {
                ui.mainTextArea.setText("Огромная рыба подплывает к вам так близко, что вы можете разглядеть её собственными глазами. Вы хватаете её собственной рукой, но она даже не сопротивлятся." +
                        "\n\n(Вы пожарили и съели рыбу. Ваше HP пополнилось на 5)");
                player.hp = player.hp + 5;
                ui.hpNumberLabel.setText("" + player.hp);
                ui.choice1.setText("Порыбачить снова");
                ui.choice2.setText("Вернуться обратно");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "fishing";
                game.nextPosition2 = "crossRoad";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else if (i > 90 && i < 95) {
                ui.mainTextArea.setText("Вы устаёте от постоянных неудач и со всей силы кидаете удочку в воду как копьё. Через несколько секунд вы замечаете всплывшее пятно крови - вы подплыва" +
                        "ете и это оказывается огромный угорь. Вы с удовольствием съедаете его!\n\n(Ваше HP пополнилось на 15!)");
                player.hp = player.hp + 15;
                ui.hpNumberLabel.setText("" + player.hp);
                ui.choice1.setText("Порыбачить снова");
                ui.choice2.setText("Вернуться обратно");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "fishing";
                game.nextPosition2 = "crossRoad";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else if (i > 95 && i < 100) {
                ui.mainTextArea.setText("Из воды выныривает огромный кит и съедает вас вместе с куском суши.");
                ui.choice1.setText("");
                ui.choice2.setText("");
                ui.choice3.setText("");
                ui.choice4.setText("Ясно...");

                game.nextPosition1 = "";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "whale";
                whaleCall = 1;
            }
        }
        else {
            ui.mainTextArea.setText("С вас хватит рыбы на сегодня");
            ui.choice1.setText("Хорошо");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "river";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void whale() {
        ui.mainTextArea.setText("Вы очутились внутри Кита. У него очень странное строение тела, потому что перед вами распутье.");
        ui.choice1.setText("Пойти влево");
        ui.choice2.setText("Пойти вперед");
        ui.choice3.setText("Пойти направо");
        ui.choice4.setText("");

        game.nextPosition1 = "whaleLeft";
        game.nextPosition2 = "whaleForward";
        game.nextPosition3 = "whaleRight";
        game.nextPosition4 = "";
    }
    public void whaleLeft() throws IOException {
        monster.setMonster("Пробудившийся Самурай");
        ui.mainTextArea.setText("Пройдя чуть дальше по китовьему кишечнику вы выходите к тупику. Там вы обнаруживаете странную картину: мужчина японской наружности, одетый в черное кимоно, сидит в " +
                "позе лотоса и медитирует с закрытыми глазами. Едва вы успеваете сделать шаг - он открывает глаза.");
        ui.choice1.setText("Вступить в бой");
        ui.choice2.setText("Убежать");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "whale";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void whaleForward(){
        if (whaleTreasure == 0) {
            ui.mainTextArea.setText("Очередной тупик: на этот раз в конце стоит светящийся деревянный ящик. Вы подходите поближе - это оказывается пиратский ящик с сокровищами и лежащей на нём " +
                    "соломенной шляпой. Выкинув шляпу, вы жадно набиваете карманы драгоценностями. (Вы находите кучу золота - в эквиваленте 100 монет!)");
            player.coin = player.coin + 100;
            ui.coinNameLabel.setText(""+player.coin);
            ui.choice1.setText("Вернуться");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "whale";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
            whaleTreasure = 1;
        }
        else {
            ui.mainTextArea.setText("Вы подходите к сундуку в надежде найти хоть что-нибудь еще, но к сожалению там пусто.");
            ui.choice1.setText(":(");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "whale";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void whaleRight(){
        ui.mainTextArea.setText("Вы выходите в огромное пустое пространство. На потолке вы замечаете закрытое отверстие. Думаю, если вежливо попросить Кита - он выкинет вас на берег.");
        ui.choice1.setText("Вежливо попросить");
        ui.choice2.setText("Вернуться");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "river";
        game.nextPosition2 = "whale";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void wagon() {
        ui.mainTextArea.setText("На дороге вы видите следы от колёс. Они ведут в лес. Пройдя по следам, вы находите тележку. Ни повозчика, ни пассажиров уже нет.");
        ui.choice1.setText("Осмотреть телегу");
        ui.choice2.setText("Уйти");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wagonSearch";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void wagonSearch() {
        if (wagonPotion == 0) {
            ui.mainTextArea.setText("Зайдя внутрь, вы ощущаете под ногами хруст стекла. В воздухе стоит невыносимый запах. [Похоже на какую-то лабораторию] - думаете вы и краем глаза " +
                    "замечаете уцелевшую колбочку на столе. На ней ничего не написано.");
            ui.choice1.setText("Отпить из неё");
            ui.choice2.setText("Уйти");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "wagonPotion";
            game.nextPosition2 = "wagon";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.mainTextArea.setText("Вы заходите в телегу еще раз в надежде найти еще одну колбочку или монеты, оставленные на полу. Но внутри больше ничего нет.");
            ui.choice1.setText("Уйти");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "wagon";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void wagonPotion() {
        ui.mainTextArea.setText("Вы чувстуете прилив сил и бодрости.\n\n(Ваше здоровье увеличилось на 10 HP!)\n\nНа полу среди стекла вы различаете разбросанные монеты.\n\n(Вы нашли 10 монет!)");
        player.hp = player.hp + 10;
        ui.hpNumberLabel.setText("" + player.hp);
        player.coin = player.coin + 10;
        ui.coinNameLabel.setText("" + player.coin);
        ui.choice1.setText("Какая удача");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        wagonPotion = 1;

        game.nextPosition1 = "wagon";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void swamp(){
        if (knightCloak == 1) {
            ui.mainTextArea.setText("Здесь больше нечего делать.");
            ui.choice1.setText("Вернуться");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else {
            ui.mainTextArea.setText("Пройдя чуть дальше вы забредаете в болото. Обойти его невозможно, но впереди в тумане вы видите одинокий силуэт. Он сидит и опирается спиной на дерево. " +
                    "Если вы пойдёте дальше - путь назад может стать проблемой.");
            ui.choice1.setText("Зайти в болото");
            ui.choice2.setText("Вернуться");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "swampKnight";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void swampKnight() throws IOException {
        monster.setMonster("Умирающий Рыцарь");
        ui.mainTextArea.setText("Сумев пробраться через трясину, вы ощущаете, что туман начал сгущаться. Вы продолжаете идти вперёд и вдруг видите перед собой ту самую фигуру. " +
                "Ей оказывается рыцарь. Из его шлема и доспехов сочится кровь. Завидев вас он поворачивает голову в вашу сторону.\nВы замечаете, что в его грудь воткнут кинжал. " +
                "\"Наконец-то... кх-кх..\" - он начал захлебываться кровью. \"Я столько ждал, пока кто-нибудь найдёт меня. Придворные Короля прокляли меня и теперь я могу пасть от любой руки " +
                "кроме своей собственной. Они связали, избили меня и бросили здесь умирать... После недели попыток проползти через трясину - я сдался . Я не знал про суть проклятья и решил убить " +
                "себя, но лишь обрёк себя на вечные страдания. Избавь меня от мучений, странник, но знай - просто так я не сдамся.\" \n(Вы забрели глубоко в болото, и, если попытаетесь вернуться," +
                " то потеряете 20 HP)");
        ui.choice1.setText("Вступить в бой");
        ui.choice2.setText("Вернуться");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "fight";
        game.nextPosition2 = "swampMinusHP";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void swampMinusHP(){

        player.hp = player.hp - 20;
        ui.hpNumberLabel.setText(""+player.hp);
        if (player.hp < 1) {
            lose();
            player.hp = 0;
            ui.hpNumberLabel.setText("" + player.hp);
        }
        else {
            ui.mainTextArea.setText("Пройдя чуть дальше вы забредаете в болото. Обойти его невозможно, но впереди в тумане вы видите одинокий силуэт. Он сидит и опирается спиной на дерево.");
            ui.choice1.setText("Зайти в болото");
            ui.choice2.setText("Вернуться");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "swampKnight";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void town(){
        if (hanging == 0) {
            ui.mainTextArea.setText("\"Дорогу!\" - вы услышали крик позади и ощущили резкий толчок в спину чем то острым. Рядом с вами проходит кортеж стражи. Внутри шагает пожилой мужчина 60 лет на вид, закованный " +
                    "в кандалы и одетый буквально в мешок. Он еле волочит ногами, скованными цепями, покорно опустив голову вниз. Увидев вас, его взгляд резко меняется. \"Сын.. Сын! Постой, это я!.. Почему" +
                    " ты здес...\" Вдруг вы замечаете человека на крыше одного из домов. Трудно назвать то, что было на нём, одеждой, скорее лохмотья, причём все черного цвета. Он замахал руками и на улице сразу же" +
                    " началась паника. Из толпы, окружавшей кортеж с двух сторон, появились несколько человек в похожей чёрной одежде. Началась драка. Стража отвлеклась, а толпа вытолкнула узника к вам. \"Разрежь кандалы!" +
                    " Скорее!\" - кричит он.");
            ui.choice1.setText("Помочь ему");
            ui.choice2.setText("Остаться в стороне");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "hangerHelped";
            game.nextPosition2 = "hangerNotHelped";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
            hanging = 1;
        }
        else {
            square();
        }
    }
    public void hangerHelped() {
        hangingChoice = 1;
        ui.mainTextArea.setText("Вы быстро разрубаете цепи и даёте узнику сбежать. Он сразу же растворяется в людской массе. Ваше участие не осталось без внимания - один из стражников, находящийся в метрах тридцати от вас, " +
                "заметил ваше преступление и начал кричать своим товарищам, чтоб они поймали вас.");
        ui.choice1.setText("Скрыться в толпе");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "square";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void hangerNotHelped(){
        hangingChoice = 0;
        ui.mainTextArea.setText("Кортеж сразу же восстанавливает порядок на улице. Но насильственным методом... Улица побагровела от количества пролитой крови. Стража без разбора " +
                "рубила всех, кто смел приблизиться к ним. Вскоре кортеж продвинулся к установке с виселицей, оставив за собой десятки трупов в чёрных одеяниях. Узника наскоро вешают, не дав " +
                "ему даже последнее слово. Из-за спешки петля не была правильно затянута и мужчина несколько минут корчился и трясся от боли.");
        ui.choice1.setText("Идти дальше");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "square";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void square(){
        ui.mainTextArea.setText("Вы выходите на городскую площадь. Прямо перед собой вы видите длинную улицу, в конце которой возвышается гигантский Королевский Замок. Взглянув на лево, " +
                "открывается вид на жилые районы города. Судя по облику зданий - район богатый. Повернув голову направо, ваш взгляд окаменевает: разрушенные дома, грязные улицы и посреди этого " +
                "торжества небольшой двухэтажный трактир.");
        ui.choice1.setText("Пойти к замку");
        ui.choice2.setText("Пойти в богатый район");
        ui.choice3.setText("Пойти к трактиру");
        ui.choice4.setText("Вернуться к воротам");
        game.nextPosition1 = "castleStairs";
        game.nextPosition2 = "richBlock";
        game.nextPosition3 = "tavernArea";
        game.nextPosition4 = "townGate";
    }
    public void castleStairs() {
        ui.mainTextArea.setText("Вы подходите к замку, там куча стражи");
        ui.choice1.setText("Поговорить");
        ui.choice2.setText("Напасть [не стоит]");
        ui.choice3.setText("Вернуться на площадь");
        ui.choice4.setText("");
        game.nextPosition1 = "talkCastleGuard";
        game.nextPosition2 = "attackCastleGuard";
        game.nextPosition3 = "square";
        game.nextPosition4 = "";
    }
    public void talkCastleGuard() {
        ui.mainTextArea.setText("Стражник1: Кто ты такой? И почему на тебе плащ Королевской Гвардии? \n\nСтражник2: Проваливай отсюда, нас такими фокусами не проведёшь.");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "castleStairs";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void attackCastleGuard(){
        ui.mainTextArea.setText("Вы решили атаковать стражу замка. Зачем - непонятно. Сначала вас схватили за руки и за ноги и несколько раз пнули ногой в живот. В итоге проходящая мимо женщина " +
                "крикнула:[Кончайте его уже!] И один из стражников достал меч и подошёл к вам.");
        ui.choice1.setText("Спросить у него зачем");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "lose";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void richBlock() {
        ui.mainTextArea.setText("Вы очутились в длинной узкой улочке. Вдали слышится повторяющийся звук удара по металлу. Рядом с собой вы замечаете лавку, на " +
                "улицу выставлены главные товары - деревянные гробы и кресты.");
        ui.choice1.setText("Зайти в лавку");
        ui.choice2.setText("Пройти дальше");
        ui.choice3.setText("Вернуться на площадь");
        ui.choice4.setText("");
        game.nextPosition1 = "woodworker";
        game.nextPosition2 = "blacksmithArea";
        game.nextPosition3 = "square";
        game.nextPosition4 = "";
    }
    public void woodworker(){
        ui.mainTextArea.setText("Внутри лавки стоит стойкий запах древесины. Это лавка плотника. Внутри куча различных подделок, но основным товаром являются деревянные коробки, " +
                "понятно для чего служащие. Пробравшись через разнообразные столы, стулья и другую деревянную мебель, вы подходите к прилавку. За ним сидит мужчина преклонного возраста и что-то стругает.");
        ui.choice1.setText("Заговорить");
        ui.choice2.setText("Выйти");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "talkWoodworker";
        game.nextPosition2 = "richBlock";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void talkWoodworker(){
        if (hangingChoice == 1) {
            ui.mainTextArea.setText("О, это ты! Я видел, что ты сделал там на площади. Но не бойся, я своих не сдаю. У меня для тебя ничего нет, разве что гробы да кресты. Но если хочешь, можешь" +
                    " взять эти вёсла. Они крепкие, выстрогал их из баобаба.\n\n(Теперь у вас есть вёсла)");
            paddle = 1;
        }
        else if (hangingChoice == 0) {
            ui.mainTextArea.setText("О, это ты! Я видел как ты не стал помогать тому мужчине на площади. Дело твоё, но будь я на твоём месте... И всё-таки у тебя даже было чем разрубить кандалы." +
                    " Я понимаю если б совсем ничего не было. Если б ты помог ему, может быть я б дал тебе мои новые вёсла. Но теперь уже ничего не попишешь. Не знаю, почему" +
                    " я это тебе вообще говорю. Лучше уходи, если ничего не будешь брать.");
        }
        ui.choice1.setText("Выйти из лавки");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "richBlock";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void blacksmithArea(){
        ui.mainTextArea.setText("Вы дошли до конца узкой улочки, ваши догадки подтвердились и звуки действительно доносились из кузницы. Слева от себя вы видите ещё одну улочку," +
                " ведущую в густую лесную рощу. Справа же - тропинку ведущую вверх в крутую гору.");

        ui.choice1.setText("Зайти к кузнецу");
        ui.choice2.setText("Пойти в лес");
        ui.choice3.setText("Пойти вверх по тропе");
        ui.choice4.setText("Вернуться");

        game.nextPosition1 = "weaponShop";
        game.nextPosition2 = "monument";
        game.nextPosition3 = "mansion";
        game.nextPosition4 = "richBlock";
    }
    public void weaponShop(){
        ui.mainTextArea.setText("В кузнице очень темно, но и лишь вдали стоит одинокая фигура и работает возле костра.");

        ui.choice1.setText("Подойти к кузнецу");
        ui.choice2.setText("Выйти");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "blacksmith";
        game.nextPosition2 = "blacksmithArea";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void blacksmith(){
        ui.mainTextArea.setText("Здравствуй, давненько ко мне не заходил кто-то не из стражи. Но я рад любому покупателю. Выбирай.");

        ui.choice1.setText("Щит (+50hp) - 20 зол.");
        ui.choice2.setText("Молот (max dmg 20) - 20 зол.");
        ui.choice3.setText("Шпага (max dmg 30) - 30 зол.");
        ui.choice4.setText("Спасибо");

        game.nextPosition1 = "shield";
        game.nextPosition2 = "hammer";
        game.nextPosition3 = "rapier";
        game.nextPosition4 = "weaponShop";
    }
    public void shield() {
        if (player.coin >= 20) {
            ui.mainTextArea.setText("Вы купили щит.\n\n(Ваше HP увеличилось на 50!)");
            player.hp = player.hp + 50;
            ui.hpNumberLabel.setText("" + player.hp);
            player.coin = player.coin - 20;
            ui.coinNameLabel.setText("" + player.coin);
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "blacksmith";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.coin < 20) {
            ui.mainTextArea.setText("Извини, друг. У тебя не хватает монет.");

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "blacksmith";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void hammer(){
        if (player.coin >= 20) {
            ui.mainTextArea.setText("Ваше оружие: " + player.currentWeapon.getName() + ".\nВы действительно хотите купить Молот?");

            ui.choice1.setText("Да");
            ui.choice2.setText("Нет");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "hammerOk";
            game.nextPosition2 = "blacksmith";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.coin < 20) {
            ui.mainTextArea.setText("Извини, друг. У тебя не хватает монет.");

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "blacksmith";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void hammerOk(){
        try {
            player.currentWeapon.setWeapon("Боевой Молот");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ui.mainTextArea.setText("Вы купили Молот!");
        player.coin = player.coin - 20;
        ui.coinNameLabel.setText("" + player.coin);
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "blacksmith";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void rapier(){
        if (player.coin >= 30) {
            ui.mainTextArea.setText("Ваше оружие: " + player.currentWeapon.getName() + ".\nВы действительно хотите купить Шпагу?");

            ui.choice1.setText("Да");
            ui.choice2.setText("Нет");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "rapierOk";
            game.nextPosition2 = "blacksmith";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.coin < 30) {
            ui.mainTextArea.setText("Извини, друг. У тебя не хватает монет.");

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "blacksmith";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void rapierOk(){
        try {
            player.currentWeapon.setWeapon("Шпага");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ui.mainTextArea.setText("Вы купили Шпагу!");
        player.coin = player.coin - 30;
        ui.coinNameLabel.setText("" + player.coin);
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "blacksmith";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void monument(){
        ui.mainTextArea.setText("Пройдя дальше по тропе вы выходите на небольшую огороженную территорию. Прямо перед вами стоит огромный бетонный памятник. А позади него виднеется небольшая церквушка.");

        ui.choice1.setText("Подойти к памятнику");
        ui.choice2.setText("Пройти дальше");
        ui.choice3.setText("Вернуться");
        ui.choice4.setText("");

        game.nextPosition1 = "monumentKing";
        game.nextPosition2 = "churchArea";
        game.nextPosition3 = "blacksmithArea";
        game.nextPosition4 = "";
    }
    public void monumentKing(){
        ui.mainTextArea.setText("\"Монумет величайшему из королей - *** XI.\"");

        ui.choice1.setText("Пройти дальше");
        ui.choice2.setText("Вернуться");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "churchArea";
        game.nextPosition2 = "monument";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void churchArea() throws IOException {
        if (witch == 0) {
            monster.setMonster("Странная Женщина");
            ui.mainTextArea.setText("Подойдя к церкви, вы заходите внутрь.\n\nВнутри довольно светло из-за многочисленных витражных окон на стенах. Стоящие впереди десятки рядов скамей пусты, кроме одной." +
                    " Вы подходите ближе и замечаете женщину, молящуюся с закрытыми глазами. Она шепчет что-то на непонятном вам языке. Решив не досаждать её, вы идете обратно к выходу. Вдруг двери церкви закрываются. Вы оборачиваетесь и видите ту же женщину - " +
                    "она стоит опустив голову вниз и продолжает шептать.");

            ui.choice1.setText("Вступить в бой");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (witch == 1) {
            ui.mainTextArea.setText("Внутри церкви больше ничего нет. Можете помолиться. Вдруг произойдёт чудо.");

            ui.choice1.setText("Хорошо");
            ui.choice2.setText("Выйти");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "churchArea";
            game.nextPosition2 = "monument";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void mansion(){
        if (fountainEvent == 0){
            ui.mainTextArea.setText("Поднясь вверх по тропе перед вами открывается захватывающий вид. Большой двух этажный особняк, огороженный невысоким заборчиком. " +
                    "Вы заходите во двор и подходите к высокому фонтану. По неясной причине вы заглядываете внутрь фонтана и достаёте оттуда горсть монет. \n\n(Вы находите 20 монет!)\n\nВозле фонтана на лавочке сидит пожилой мужчина. " +
                    "Он сидит к вам спиной, но его присутствие ощущается на расстоянии. Он медленно встаёт и поворачивается к вам. На его груди вы замечаете ту же эмблему, что носят солдаты. Ни успев" +
                    " промолвить и слова, из ниоткуда появляется гарнизон стражи. \"Скорее! Взять его - он хочет убить господина!\" Мужчина в недоумении, как и вы, но рыцари все ближе и ближе.");

            ui.choice1.setText("Ничего не делать");
            ui.choice2.setText("Взять его в заложники");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "fountainDoNothing";
            game.nextPosition2 = "fountainHostage";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

            fountainEvent = 1;
        }
        else if (fountainEvent == 1) {
            ui.mainTextArea.setText("Ворота в поместье закрыты.");

            ui.choice1.setText("Вернуться");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "blacksmithArea";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void fountainDoNothing(){
        ui.mainTextArea.setText("Стража окружает вас и без лишних колебаний убивает.");

        ui.choice1.setText("Да");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Или нет?");

        game.nextPosition1 = "lose";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "square";
    }
    public void fountainHostage(){
        ui.mainTextArea.setText("Вы хватаете мужчину и пристявляете ему "+player.currentWeapon.getName()+" к горлу. Стража отступаете и вы сбегаете.");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "blacksmithArea";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void tavernArea() {
        ui.mainTextArea.setText("Вы подходите к таверне. Вокруг повсюду мусор и грязь, рядом валяются пьяницы. ");

        ui.choice1.setText("Зайти в таверну");
        ui.choice2.setText("Обойти таверну");
        ui.choice3.setText("Вернуться на площадь");
        ui.choice4.setText("");

        game.nextPosition1 = "tavern";
        game.nextPosition2 = "channelsArea";
        game.nextPosition3 = "square";
        game.nextPosition4 = "";
    }
    public void tavern(){
        ui.mainTextArea.setText("Внутри таверны куча народу, все празднуют и веселятся, хотя никакого праздника сегодня нет. Краем уха вы улавливаете разговор двух мужчин в черной одежде, сидящих " +
                "в дальнем углу." +
                "\"Что не так с этим городом?\" \"Не знаю, но стража еще не обнаружила наш потайной ход в канализации под городом\" \"Надолго ли?\" ");
        ui.choice1.setText("Выйти из таверны");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tavernArea";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void channelsArea(){
        ui.mainTextArea.setText("Вы за таверной. Зайдя за угол вы обнаруживаете мужчину, сидящего на люке.");

        ui.choice1.setText("Залезть в люк");
        ui.choice2.setText("Вернуться к главному входу");
        ui.choice3.setText("");
        ui.choice4.setText("");
        if (fountainEvent == 1) {
            game.nextPosition1 = "channels";
            game.nextPosition2 = "tavernArea";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else {
            game.nextPosition1 = "channelsDenied";
            game.nextPosition2 = "tavernArea";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void channelsDenied(){
        ui.mainTextArea.setText("Кто ты?. Проваливай отсюда!");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "channelsArea";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void channels(){
        ui.mainTextArea.setText("\"А это ты? Я видел как ты пытался убить отца предводителя королевской стражи. Смелый поступок, хоть и не завершённый, пока что. Проходи, что уж тут.\"\n\nВы спускаетесь по лестнице вниз и оказываетесь в канализации. Стены вылажены кладкой а на полу вода глубиной пару сантиметров. Вы продвигаетесь дальше" +
                " и доходите до развилки.");

        ui.choice1.setText("Пойти налево");
        ui.choice2.setText("Пойти направо");
        ui.choice3.setText("Вернуться");
        ui.choice4.setText("");

        game.nextPosition1 = "channelsLeft";
        game.nextPosition2 = "channelsRight";
        game.nextPosition3 = "channelsArea";
        game.nextPosition4 = "";
    }
    public void channelsLeft(){
        ui.mainTextArea.setText("Вы доходите до тупика. Перед вами лестница, ведущая вверх.");

        ui.choice1.setText("Взобраться по лестнице");
        ui.choice2.setText("Вернуться");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "castle";
        game.nextPosition2 = "channels";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void channelsRight() throws IOException {
        monster.setMonster("Гигантская Крыса");
        ui.mainTextArea.setText("Вы идёте по темному каналу. Вокруг слышится постоянное пищанье, но никого не видно. В один момент вы руками нащупываете тупик, а пищанье сзади становится всё громче и громче." +
                " Вы оборачиваетесь и видите перед собой огромную крысу.");

        ui.choice1.setText("Вступить в бой");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void castle() throws IOException {
        monster.setMonster("Глава Стражи");
        ui.mainTextArea.setText("Вы открываете люк и вылезаете из него. Оглядевшись вокруг вы понимаете, что вы позади трона самого короля! Он сейчас занят приемом гостей, сидя на самом троне." +
                " Рядом с ним стоит мужчина в золотом доспехе и огромным мечом. Он замечает вас и приказывает обычным стражникам быстро увести его Величество в безопасное место, а сам приближается к вам.");

        ui.choice1.setText("Вступить в бой");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


















    public void fight() {
        ui.mainTextArea.setText(monster.getName() +": " + monster.gethp() +" HP\nВаши действия?");
        if (monster.getName() == "Умирающий Рыцарь") {
            ui.choice1.setText("Атаковать");
            ui.choice2.setText("Убежать");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "swampMinusHP";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (monster.getName() == "Пробудившийся Самурай") {
            ui.choice1.setText("Атаковать");
            ui.choice2.setText("Убежать");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "whale";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (monster.getName() == "Странная Женщина") {
            ui.choice1.setText("Атаковать");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (monster.getName() == "Гигантская Крыса") {
            ui.choice1.setText("Атаковать");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (monster.getName() == "Глава Стражи") {
            ui.choice1.setText("Атаковать");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
    public void playerAttack() {

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.getDamage());
        ui.mainTextArea.setText("Вы атаковали " + monster.getName() + " и нанесли " + playerDamage+ " damage");
        monster.sethp(monster.gethp() - playerDamage);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.gethp() > 0) {
            int i = new java.util.Random().nextInt(3);
            if (i == 0) {
                game.nextPosition1 = "monsterAttack1";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else if (i == 1) {
                game.nextPosition1 = "monsterAttack2";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else if (i == 2) {
                game.nextPosition1 = "monsterAttack3";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }

        else if (monster.gethp() < 1) {
            if(monster.getName() == "Умирающий Рыцарь") {
                game.nextPosition1 = "winKnight";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else  if (monster.getName() == "Пробудившийся Самурай"){
                game.nextPosition1 = "winSamurai";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else  if (monster.getName() == "Странная Женщина"){
                game.nextPosition1 = "winWitch";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else  if (monster.getName() == "Гигантская Крыса"){
                game.nextPosition1 = "winRat";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else  if (monster.getName() == "Глава Стражи"){
                game.nextPosition1 = "endingWin";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            }
        }
    public void monsterAttack1(){

        int monsterDamage = new java.util.Random().nextInt(monster.getAttack());

        ui.mainTextArea.setText(monster.getAttackMessage1()+ "\nВы получили " + monsterDamage+ " damage!");

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.hp < 1) {
            player.hp = 0;
            ui.hpNumberLabel.setText("" + player.hp);
            if (monster.getName() == "Глава Стражи") {

            }
            else {
                game.nextPosition1 = "lose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }
    }
    public void monsterAttack2(){

        int monsterDamage = new java.util.Random().nextInt(monster.getAttack());

        ui.mainTextArea.setText(monster.getAttackMessage2()+ "\nВы получили " + monsterDamage+ " damage!");

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.hp < 1) {
            player.hp = 0;
            ui.hpNumberLabel.setText("" + player.hp);
            if (monster.getName() == "Глава Стражи") {

            }
            else {
                game.nextPosition1 = "lose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }
    }
    public void monsterAttack3(){

        int monsterDamage = new java.util.Random().nextInt(monster.getAttack());

        ui.mainTextArea.setText(monster.getAttackMessage3()+ "\nВы получили " + monsterDamage+ " damage!");

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.hp < 1) {
            player.hp = 0;
            ui.hpNumberLabel.setText("" + player.hp);
            if (monster.getName() == "Глава Стражи") {
                game.nextPosition1 = "endingLose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
            else {
                game.nextPosition1 = "lose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }
    }
    public void winKnight() {
        se.setFile(applause); se.play();
        ui.mainTextArea.setText("Вы убили "+monster.getName()+"!\nОн наконец-то свободен от вечных мучений. Обыскав его тело вы находите горсть монет. Его доспехи не подходят вам по размеру, " +
                "поэтому вы берёте только его меч и плащ. Только слепой примет вас за одного из рыцарей.\n\n(У вас новое оружие! : Рыцарский Меч [max dmg = 12])\n\n(Вы надели рыцарский плащ!)\n\n(Вы нашли 15 золотых!)");
        knightCloak = 1;
        try {
            player.currentWeapon.setWeapon("Рыцарский Меч");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        player.coin = player.coin + 15;
        ui.coinNameLabel.setText("" + player.coin);

        ui.choice1.setText("Вернуться");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void winSamurai(){
        se.setFile(applause); se.play();
        ui.mainTextArea.setText("Вы победили "+monster.getName()+"!\nВы не стали его убивать, но в знак превосходства нагло забираете его катану, не зная ни имя её владельца, ни её многовековую историю. " +
                "Также вы съедаете недельный запас риса бедолаги.\n\n(Ваше HP пополнилось на 30!)");
        try {
            player.currentWeapon.setWeapon("Катана времён Муромати");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
        player.hp = player.hp + 30;
        ui.hpNumberLabel.setText(""+player.hp);

        ui.choice1.setText("Вернуться");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "whale";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void winWitch(){
        se.setFile(applause); se.play();
        ui.mainTextArea.setText("Вы победили "+monster.getName()+"!\nПосле смерти от неё не осталось никаких следов, кроме золотого креста на полу. Вы подбираете его как трофей.\n\n(Вы получили 20 монет!)");

        player.hp = player.hp + 20;
        ui.hpNumberLabel.setText(""+player.hp);
        player.coin = player.coin + 20;
        ui.coinNameLabel.setText(""+player.coin);


        ui.choice1.setText("Вернуться");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "monument";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        witch = 1;
    }
    public void winRat(){
        se.setFile(applause); se.play();
        ui.mainTextArea.setText("Вы победили "+monster.getName()+"!\nВы убили и съели её сырой!\n\n(Ваше HP увеличилось на 40!)");

        player.hp = player.hp + 40;
        ui.hpNumberLabel.setText(""+player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "channels";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        witch = 1;
    }
    public void endingWin(){
        se.setFile(applause); se.play();
        ui.mainTextArea.setText("Своим "+player.currentWeapon.getName() + " вы пронзаете рыцарю сердце и оставляете его умирать. Другая стража не смеет даже думать о том, чтоб напасть на вас. Они выдают вам " +
                "короля. Вы же решаете провести прилюдный самосуд.  \n\n<THE END>");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }
    public void endingLose(){
        ui.mainTextArea.setText("Стражник побеждает вас и безжалостно убивает. Король продолжает править в этом городе до скончания дней своих. \n\n<THE END>");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }
    public void lose() {
        ui.mainTextArea.setText("Вы мертвы!\n\n<GAME OVER>");
        ui.choice1.setText("На главный экран");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }
}


