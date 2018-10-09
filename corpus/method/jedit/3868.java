//}}}
//{{{ getSelectedClipText()
private String getSelectedClipText() {
    java.util.List selected = clips.getSelectedValuesList();
    if (selected == null || selected.isEmpty())
        return "";
    if (selected.size() == 1) {
        // instead of making a copy, do so
        return selected.get(0).toString();
    } else {
        StringBuilder clip = new StringBuilder();
        for (int i = 0; i < selected.size(); i++) {
            if (i != 0)
                clip.append('\n');
            clip.append(selected.get(i));
        }
        return clip.toString();
    }
}