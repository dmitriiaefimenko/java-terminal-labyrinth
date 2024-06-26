package com.github.dmitriiaefimenko.java.terminal.labyrinth;

import com.github.dmitriiaefimenko.java.terminal.labyrinth.gui.GUI;
import com.github.dmitriiaefimenko.java.terminal.labyrinth.system.*;
import com.github.dmitriiaefimenko.java.terminal.labyrinth.type.Message;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TerminalLabyrinthApp {

    private static final long FPS_MESSAGE   = 1000 / 30;
    private static final long FPS_ACTION    = 1000 / 60;
    public static boolean ENABLE_DEBUG_MAP  = false;
    public static boolean RENDER_MAP        = false;
    public static long TIME_LIMIT_MINUTES   = 5;
    public static int CARD_NUMBER           = 3;

    public static final Random RANDOM       = new Random();
    public static boolean ENTER_LABYRINTH   = false;

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        Runnable initGUI = GUI::new;
        SwingUtilities.invokeAndWait(initGUI);

        SoundSystem.initLogoSound();
        while (!ENTER_LABYRINTH) {
            RenderSystem.runLogoRenderingCycle();
            TimeUnit.MILLISECONDS.sleep(FPS_MESSAGE);
        }

        SoundSystem.initMainSound();
        while (true) {
            ControlSystem.calculateMovement();
            CardSystem.isUserReachedCard();
            if (MapSystem.isUserReachedExit() && CardSystem.getCardsLeft() == 0) {
                SoundSystem.muteSound();
                while (true) {
                    RenderSystem.runSurvivedRenderingCycle();
                    TimeUnit.MILLISECONDS.sleep(FPS_MESSAGE);
                }
            }
            HunterSystem.moveHunters();
            if (HunterSystem.isHunterReachedUser()) {
                SoundSystem.muteSound();
                while (true) {
                    RenderSystem.runDeathRenderingCycle(Message.DEATH_BY_HUNTER);
                    TimeUnit.MILLISECONDS.sleep(FPS_MESSAGE);
                }
            }
            if (TimerSystem.isReachedTimeLimit()) {
                SoundSystem.muteSound();
                while (true) {
                    RenderSystem.runDeathRenderingCycle(Message.DEATH_BY_TIME_LIMIT);
                    TimeUnit.MILLISECONDS.sleep(FPS_MESSAGE);
                }
            }
            RenderSystem.runMainRenderingCycle();
            TimeUnit.MILLISECONDS.sleep(FPS_ACTION);
        }
    }
}
