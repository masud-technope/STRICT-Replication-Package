//}}}
//{{{ userInput() method
protected void userInput(char ch) {
    lastActionCount = 0;
    JEditTextArea textArea = view.getTextArea();
    if (repeatCount == 1)
        textArea.userInput(ch);
    else {
        // stop people doing dumb stuff like C+ENTER 100 C+n
        if (repeatCount > REPEAT_COUNT_THRESHOLD) {
            Object[] pp = { String.valueOf(ch), repeatCount };
            if (GUIUtilities.confirm(view, "large-repeat-count.user-input", pp, JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                repeatCount = 1;
                view.getStatus().setMessage(null);
                return;
            }
        }
        JEditBuffer buffer = view.getBuffer();
        try {
            if (repeatCount != 1)
                buffer.beginCompoundEdit();
            for (int i = 0; i < repeatCount; i++) textArea.userInput(ch);
        } finally {
            if (repeatCount != 1)
                buffer.endCompoundEdit();
        }
    }
    Macros.Recorder recorder = view.getMacroRecorder();
    if (recorder != null) {
        recorder.recordInput(repeatCount, ch, textArea.isOverwriteEnabled());
    }
    repeatCount = 1;
}