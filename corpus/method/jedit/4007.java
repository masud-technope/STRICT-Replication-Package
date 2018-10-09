public void update() {
    Buffer buffer = view.getBuffer();
    if (buffer.isLoaded())
        encoding.setText(buffer.getStringProperty("encoding"));
}