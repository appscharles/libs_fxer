package com.appscharles.libs.fxer.models;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 05.09.2018
 * Time: 12:49
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class MenuItemTreeView {

    private String text;

    private String resourceIcon;

    private Runnable switchPane;

    public MenuItemTreeView(String text, String resourceIcon, Runnable switchPane) {
        this.text = text;
        this.resourceIcon = resourceIcon;
        this.switchPane = switchPane;
    }

    /**
     * Getter for property 'text'.
     *
     * @return Value for property 'text'.
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for property 'text'.
     *
     * @param text Value to set for property 'text'.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter for property 'resourceIcon'.
     *
     * @return Value for property 'resourceIcon'.
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * Setter for property 'resourceIcon'.
     *
     * @param resourceIcon Value to set for property 'resourceIcon'.
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * Getter for property 'switchPane'.
     *
     * @return Value for property 'switchPane'.
     */
    public Runnable getSwitchPane() {
        return switchPane;
    }

    /**
     * Setter for property 'switchPane'.
     *
     * @param switchPane Value to set for property 'switchPane'.
     */
    public void setSwitchPane(Runnable switchPane) {
        this.switchPane = switchPane;
    }
}
