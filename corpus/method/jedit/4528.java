//}}}
//{{{ invokeAction() method
/**
	 * Invokes the specified action, repeating and recording it as
	 * necessary.
	 * @param action The action
	 */
@Override
public void invokeAction(JEditBeanShellAction action) {
    JEditBuffer buffer = textArea.getBuffer();
    // remember the last executed action
    if (!action.noRememberLast()) {
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
        action.invoke(textArea);
    else {
        try {
            buffer.beginCompoundEdit();
            for (int i = 0; i < _repeatCount; i++) action.invoke(textArea);
        } finally {
            buffer.endCompoundEdit();
        }
    }
    // Otherwise it might have been set by the action, etc
    if (_repeatCount != 1) {
        // readNextChar, do not clear the repeat
        if (readNextChar != null)
            return;
        repeatCount = 1;
    }
}