// {{{ _save() method
@Override
protected void _save() {
    jEdit.setProperty("buffer.defaultMode", ((Mode) defaultMode.getSelectedItem()).getName());
    Iterator<Mode> available = pingPongList.getLeftDataIterator();
    while (available.hasNext()) {
        Mode mode = available.next();
        jEdit.setBooleanProperty("mode.opt-out." + mode.getName(), true);
    }
    Iterator<Mode> selected = pingPongList.getRightDataIterator();
    while (selected.hasNext()) {
        Mode mode = selected.next();
        jEdit.unsetProperty("mode.opt-out." + mode.getName());
    }
}