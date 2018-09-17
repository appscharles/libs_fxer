package com.appscharles.libs.fxer.hidders;

import javafx.scene.control.Button;

/**
 * The type Button shower.
 */
public class ButtonHidder {

    /**
     * Hide.
     *
     * @param button the button
     */
    public static void hide(Button button){
        button.setVisible(false);
        button.setManaged(false);
    }
}
