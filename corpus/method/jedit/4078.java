public void update() {
    Buffer buffer = view.getBuffer();
    if (buffer.isLoaded())
        mode.setText(buffer.getMode().toString());
}