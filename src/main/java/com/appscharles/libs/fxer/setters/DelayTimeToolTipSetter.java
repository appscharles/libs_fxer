package com.appscharles.libs.fxer.setters;

import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.lang.reflect.Field;

/**
 * The type Delay time tool tip setter.
 */
public class DelayTimeToolTipSetter {

    /**
     * Sets delay.
     *
     * @param openDuration    the open duration
     * @param visibleDuration the visible duration
     * @param closeDuration   the close duration
     * @param tooltip         the tooltip
     * @throws FxerException the fxer exception
     */
    public static void setDelay(Integer openDuration, Integer visibleDuration, Integer closeDuration, Tooltip tooltip) throws FxerException {
        try {
            Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
            fieldBehavior.setAccessible(true);
            Object objBehavior = fieldBehavior.get(tooltip);
            Field fieldActivationTimer = objBehavior.getClass().getDeclaredField("activationTimer");
            Field fieldHideTimer = objBehavior.getClass().getDeclaredField("hideTimer");
           Field fieldLeftTimer = objBehavior.getClass().getDeclaredField("leftTimer");
            fieldActivationTimer.setAccessible(true);
            fieldHideTimer.setAccessible(true);
            fieldLeftTimer.setAccessible(true);
            Timeline objActivationTimer = (Timeline) fieldActivationTimer.get(objBehavior);
            Timeline objHideTimer = (Timeline) fieldHideTimer.get(objBehavior);
            Timeline objLeftTimer = (Timeline) fieldLeftTimer.get(objBehavior);
            objActivationTimer.getKeyFrames().clear();
            objHideTimer.getKeyFrames().clear();
            objLeftTimer.getKeyFrames().clear();
            objActivationTimer.getKeyFrames().add(new KeyFrame(new Duration(openDuration)));
            objHideTimer.getKeyFrames().add(new KeyFrame(new Duration(visibleDuration)));
            objLeftTimer.getKeyFrames().add(new KeyFrame(new Duration(closeDuration)));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new FxerException(e);
        }
    }
}
