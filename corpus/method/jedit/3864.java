//}}}
//{{{ ok() method
public void ok() {
    java.util.List<String> selected = clips.getSelectedValuesList();
    if (selected == null || selected.isEmpty()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    String text = getSelectedClipText();
    /**
		 * For each selected clip, we remove it, then add it back
		 * to the model. This has the effect of moving it to the
		 * top of the list.
		 */
    for (String sel : selected) {
        listModel.removeElement(sel);
        listModel.insertElementAt(sel, 0);
    }
    view.getTextArea().setSelectedText(text);
    cleanup();
}