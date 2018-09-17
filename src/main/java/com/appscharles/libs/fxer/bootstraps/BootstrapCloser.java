package com.appscharles.libs.fxer.bootstraps;

import com.appscharles.libs.fxer.models.BootstrapCloserContainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Bootstrap closer.
 */
public class BootstrapCloser {

    private static Boolean closing;

    private static List<BootstrapCloserContainer> bootstrapCloserContainers;

    static {
        if (closing == null){
            closing = false;
            bootstrapCloserContainers = new ArrayList<>();
        }
    }

    /**
     * Call close.
     */
    public static void callClose() {
        if (closing == false){
            closing = true;
            bootstrapCloserContainers.sort(Comparator.comparing(BootstrapCloserContainer::getOrder));
            for (BootstrapCloserContainer bootstrapCloserContainer : bootstrapCloserContainers) {
                bootstrapCloserContainer.getOnClose().run();
            }
        }
    }

    /**
     * Add bootstrap closer container.
     *
     * @param bootstrapCloserContainer the bootstrap closer container
     */
    public static void addBootstrapCloserContainer(BootstrapCloserContainer bootstrapCloserContainer){
        bootstrapCloserContainers.add(bootstrapCloserContainer);
    }
}
