//{{{ ScreenLineManager constructor
 ScreenLineManager(JEditBuffer buffer) {
    this.buffer = buffer;
    if (!buffer.isLoading())
        reset();
}