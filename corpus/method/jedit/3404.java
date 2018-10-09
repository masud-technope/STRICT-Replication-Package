private String getCurrentEditMode(View view) {
    Buffer buffer = view.getBuffer();
    if (buffer == null)
        return null;
    Mode bufferMode = buffer.getMode();
    if (bufferMode == null)
        return null;
    return bufferMode.getName();
}