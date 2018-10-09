//}}}
private static Mode getDefaultMode() {
    Mode defaultMode = jEdit.getMode(jEdit.getProperty("buffer.defaultMode"));
    if (defaultMode == null)
        defaultMode = jEdit.getMode("text");
    return defaultMode;
}