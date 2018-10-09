private void saveModeLayout(View view, String mode) {
    String modeLayout = getModePerspective(mode);
    if (modeLayout == null)
        return;
    save(view, modeLayout);
}