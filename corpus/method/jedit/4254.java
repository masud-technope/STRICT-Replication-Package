//{{{ cancelResizeSave() method
private void cancelResizeSave() {
    if (resizeDelayFuture != null) {
        resizeDelayFuture.cancel(false);
        resizeDelayFuture = null;
    }
}