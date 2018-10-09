private static void addAction(String layoutName) {
    if ((actions != null) && (!actions.contains(layoutName)))
        actions.addAction(new LoadPerspectiveAction(layoutName));
}