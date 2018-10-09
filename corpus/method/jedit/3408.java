private String getModePerspective(String mode) {
    if (mode == null)
        mode = GLOBAL_MODE;
    return "mode-" + mode;
}