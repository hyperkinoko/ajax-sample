package net.kinokolabo.reservation.domain;

public enum JoinOrLeave {
    JOIN("入室"), LEAVE("退室");

    private final String actionName;

    private JoinOrLeave(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}
