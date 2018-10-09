//}}}
//{{{ addToLetterMap() method
private void addToLetterMap(List<List<JMenuItem>> letters, JMenuItem item) {
    char ch = item.getText().charAt(0);
    ch = Character.toUpperCase(ch);
    if (ch < 'A' || ch > 'Z') {
        Log.log(Log.ERROR, this, "Plugin menu item label must " + "begin with A - Z, or a - z: " + item.getText());
    } else
        letters.get(ch - 'A').add(item);
}