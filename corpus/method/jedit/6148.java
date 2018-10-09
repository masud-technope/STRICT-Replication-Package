public void goTo(EditPane editPane) {
    Buffer buffer = getBuffer(editPane.getView());
    if (buffer == null)
        return;
    editPane.setBuffer(buffer);
}