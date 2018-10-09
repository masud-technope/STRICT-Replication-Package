//}}}
//{{{ updateButtons() method
private void updateButtons() {
    int selected = clips.getSelectedIndex();
    insert.setEnabled(selected != -1);
}