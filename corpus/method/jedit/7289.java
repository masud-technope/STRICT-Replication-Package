//}}}
//{{{ insert() method
protected void insert(String str, boolean indent) {
    try {
        // the line
        if (overwrite || indent)
            buffer.beginCompoundEdit();
        if (overwrite) {
            int caretLineEnd = getLineEndOffset(caretLine);
            if (caretLineEnd - caret > 1)
                deleteNextCharacter(caret);
        }
        buffer.insert(caret, str);
        if (indent)
            buffer.indentLine(caretLine, true);
    } finally {
        if (overwrite || indent)
            buffer.endCompoundEdit();
    }
}