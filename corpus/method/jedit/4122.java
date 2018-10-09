private boolean largeBufferDeactivateWrap() {
    Buffer buffer = view.getBuffer();
    String largeFileMode = buffer.getStringProperty("largefilemode");
    return "limited".equals(largeFileMode) || "nohighlight".equals(largeFileMode);
}