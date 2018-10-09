//{{{ save() method
public void save() {
    for (StyleChoice ch : styleChoices) {
        jEdit.setProperty(ch.property, GUIUtilities.getStyleString(ch.style));
    }
//}}}
}