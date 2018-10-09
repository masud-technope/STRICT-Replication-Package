//}}}
//{{{ keyTyped() medhod
protected void keyTyped(KeyEvent e) {
    char ch = e.getKeyChar();
    if (jEdit.getBooleanProperty("insertCompletionWithDigit") && Character.isDigit(ch)) {
        int index = ch - '0';
        if (index == 0)
            index = 9;
        else
            index--;
        if (index < getCandidates().getSize()) {
            setSelectedIndex(index);
            if (doSelectedCompletion()) {
                e.consume();
                dispose();
            }
            return;
        } else
            /* fall through */
            ;
    }
    // \t handled above
    if (ch != '\b' && ch != '\t') {
        /* eg, foo<C+b>, will insert foobar, */
        if (!Character.isLetterOrDigit(ch) && noWordSep.indexOf(ch) == -1) {
            doSelectedCompletion();
            textArea.userInput(ch);
            e.consume();
            dispose();
            return;
        }
        textArea.userInput(ch);
        e.consume();
        resetWords(word + ch);
    }
}