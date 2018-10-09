public static void loadCurrentModeLayout(View view) {
    if (view == null)
        return;
    String mode = instance.getCurrentEditMode(view);
    instance.loadModeLayout(view, mode);
}