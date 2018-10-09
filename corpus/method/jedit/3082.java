//}}}
//{{{ complete() method
private void complete(boolean insertLongestPrefix) {
    String text = action.getText().trim();
    String[] completions = getCompletions(text);
    if (completions.length == 1) {
        if (insertLongestPrefix)
            action.setText(completions[0]);
    } else if (completions.length != 0) {
        if (insertLongestPrefix) {
            String prefix = MiscUtilities.getLongestPrefix(completions, true);
            if (prefix.contains(text))
                action.setText(prefix);
        }
        if (popup != null)
            popup.setModel(completions);
        else
            popup = new CompletionPopup(completions);
        return;
    }
    if (popup != null) {
        popup.dispose();
        popup = null;
    }
}