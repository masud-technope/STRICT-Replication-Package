public void update() {
    Buffer buffer = view.getBuffer();
    if (buffer.isLoaded())
        fold.setText((String) view.getBuffer().getProperty("folding"));
}