//}}}
//{{{ invokeAction() method
/**
	 * Invokes the specified action, repeating and recording it as
	 * necessary.
	 * @param action The action
	 */
@Override
public void invokeAction(EditAction action) {
    JEditBuffer buffer = view.getBuffer();
    // remember the last executed action
    if (!action.noRememberLast()) {
        HistoryModel.getModel("action").addItem(action.getName());
        if (lastAction == action)
            lastActionCount++;
        else {
            lastAction = action;
            lastActionCount = 1;
        }
    }
    // remember old values, in case action changes them
    int _repeatCount = repeatCount;
    // execute the action
    if (action.noRepeat() || _repeatCount == 1)
        action.invoke(view);
    else {
        // stop people doing dumb stuff like C+ENTER 100 C+n
        if (_repeatCount > REPEAT_COUNT_THRESHOLD) {
            String label = action.getLabel();
            if (label == null)
                label = action.getName();
            else
                label = GenericGUIUtilities.prettifyMenuLabel(label);
            Object[] pp = { label, _repeatCount };
            if (GUIUtilities.confirm(view, "large-repeat-count", pp, JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                repeatCount = 1;
                view.getStatus().setMessage(null);
                return;
            }
        }
        try {
            buffer.beginCompoundEdit();
            for (int i = 0; i < _repeatCount; i++) action.invoke(view);
        } finally {
            buffer.endCompoundEdit();
        }
    }
    Macros.Recorder recorder = view.getMacroRecorder();
    if (recorder != null && !action.noRecord())
        recorder.record(_repeatCount, action.getCode());
    // Otherwise it might have been set by the action, etc
    if (_repeatCount != 1) {
        // readNextChar, do not clear the repeat
        if (readNextChar != null)
            return;
        repeatCount = 1;
        view.getStatus().setMessage(null);
    }
}