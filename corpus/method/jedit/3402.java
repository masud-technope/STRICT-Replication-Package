private void loadModeLayout(View view, String mode) {
    String modeLayout = getModePerspective(mode);
    if (modeLayout == null)
        return;
    load(view, modeLayout);
}