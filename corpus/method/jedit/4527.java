//}}}
//{{{ handleKey() method
/**
	 * Handles the given keystroke.
	 * @param keyStroke The key stroke
	 * @param dryRun only calculate the return value, do not have any other effect
	 * @since jEdit 4.2pre5
	 */
@Override
public boolean handleKey(KeyEventTranslator.Key keyStroke, boolean dryRun) {
    char input = '\0';
    if (keyStroke.modifiers == null || keyStroke.modifiers.equals("S")) {
        switch(keyStroke.key) {
            case '\n':
            case '\t':
                input = (char) keyStroke.key;
                break;
            default:
                input = keyStroke.input;
                break;
        }
    }
    if (readNextChar != null) {
        if (input != '\0') {
            if (!dryRun) {
                setCurrentBindings(bindings);
                invokeReadNextChar(input);
                repeatCount = 1;
            }
            return true;
        } else {
            if (!dryRun) {
                readNextChar = null;
            }
        }
    }
    Object o = currentBindings.get(keyStroke);
    if (o == null) {
        if (!dryRun) {
            // beep when caps lock is pressed, etc.
            if (currentBindings != bindings) {
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                // F10 should be passed on, but C+e F10
                // shouldn't
                repeatCount = 1;
                setCurrentBindings(bindings);
            } else if (input != '\0') {
                if (!keyStroke.isFromGlobalContext()) // let user input be only local
                {
                    userInput(input);
                }
            }
            sendShortcutPrefixOff();
        }
    } else if (o instanceof Hashtable) {
        if (!dryRun) {
            setCurrentBindings((Hashtable) o);
            ShortcutPrefixActiveEvent.firePrefixStateChange(currentBindings, true);
            shortcutOn = true;
        }
        return true;
    } else if (o instanceof String) {
        if (!dryRun) {
            setCurrentBindings(bindings);
            sendShortcutPrefixOff();
            invokeAction((String) o);
        }
        return true;
    } else if (o instanceof JEditBeanShellAction) {
        if (!dryRun) {
            setCurrentBindings(bindings);
            sendShortcutPrefixOff();
            invokeAction((JEditBeanShellAction) o);
        }
        return true;
    }
    if (!dryRun) {
        sendShortcutPrefixOff();
    }
    return false;
}