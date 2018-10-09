//}}}
//{{{ expandAbbrev() method
/**
	 * Expands the abbrev at the caret position in the specified
	 * view.
	 * @param view The view
	 * @param add If true and abbrev not found, will ask user if
	 * it should be added
	 * @return if expanded
	 * @since jEdit 2.6pre4
	 */
public static boolean expandAbbrev(View view, boolean add) {
    //{{{ Figure out some minor things
    Buffer buffer = view.getBuffer();
    JEditTextArea textArea = view.getTextArea();
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return false;
    }
    int line = textArea.getCaretLine();
    int lineStart = buffer.getLineStartOffset(line);
    int caret = textArea.getCaretPosition();
    String lineText = buffer.getLineText(line);
    if (lineText.length() == 0) {
        if (add)
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return false;
    }
    int pos = caret - lineStart;
    if (pos == 0) {
        if (add)
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return false;
    //}}}
    }
    // we reuse the 'pp' vector to save time
    m_pp.removeAllElements();
    int wordStart;
    String abbrev;
    //{{{ Handle abbrevs of the form abbrev#pos1#pos2#pos3#...
    if (lineText.charAt(pos - 1) == '#') {
        wordStart = lineText.indexOf('#');
        wordStart = TextUtilities.findWordStart(lineText, wordStart, buffer.getStringProperty("noWordSep") + '#');
        abbrev = lineText.substring(wordStart, pos - 1);
        // positional parameters will be inserted where $1, $2, $3, ...
        // occurs in the expansion
        int lastIndex = 0;
        for (int i = 0; i < abbrev.length(); i++) {
            if (abbrev.charAt(i) == '#') {
                m_pp.addElement(abbrev.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }
        m_pp.addElement(abbrev.substring(lastIndex));
        // the first element of pp is the abbrev itself
        abbrev = m_pp.elementAt(0);
        m_pp.removeElementAt(0);
    //}}}
    } else //{{{ Handle ordinary abbrevs
    {
        wordStart = TextUtilities.findWordStart(lineText, pos - 1, buffer.getStringProperty("noWordSep"));
        abbrev = lineText.substring(wordStart, pos);
    //}}}
    }
    Expansion expand = expandAbbrev(buffer.getMode().getName(), abbrev, (buffer.getBooleanProperty("noTabs") ? buffer.getTabSize() : 0), m_pp);
    //{{{ Maybe show add abbrev dialog
    if (expand == null) {
        if (add)
            new AddAbbrevDialog(view, abbrev);
        return false;
    //}}}
    } else //{{{ Insert the expansion
    {
        buffer.remove(lineStart + wordStart, pos - wordStart);
        int whitespace = buffer.insertIndented(lineStart + wordStart, expand.text);
        int newlines = countNewlines(expand.text, expand.caretPosition);
        if (expand.caretPosition != -1) {
            textArea.setCaretPosition(lineStart + wordStart + expand.caretPosition + newlines * whitespace);
        }
        if (expand.posParamCount != m_pp.size()) {
            view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.incomplete-abbrev", new Integer[] { Integer.valueOf(m_pp.size()), Integer.valueOf(expand.posParamCount) }));
        }
        return true;
    //}}}
    }
}