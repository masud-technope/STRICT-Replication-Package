public static void saveCurrentModeLayout(View view) {
    if (view == null)
        return;
    String mode = instance.getCurrentEditMode(view);
    instance.saveModeLayout(view, mode);
}