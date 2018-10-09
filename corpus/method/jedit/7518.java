public  ViewConfig(boolean plainView) {
    this.plainView = plainView;
    String prefix = plainView ? "plain-view" : "view";
    x = jEdit.getIntegerProperty(prefix + ".x", 0);
    y = jEdit.getIntegerProperty(prefix + ".y", 0);
    width = jEdit.getIntegerProperty(prefix + ".width", 0);
    height = jEdit.getIntegerProperty(prefix + ".height", 0);
    extState = jEdit.getIntegerProperty(prefix + ".extendedState", Frame.NORMAL);
}