package com.appscharles.libs.fxer.showers;

import javafx.scene.control.Button;

/**
 * The type Button shower.
 */
public class ButtonShower {

    /**
     * Show.
     *
     * @param button the button
     */
    public static void show(Button button){
        button.setVisible(true);
        button.setManaged(true);
    }

}
