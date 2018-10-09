//}}}
//{{{ showStructureStatusMessage() method
private void showStructureStatusMessage(boolean backward) {
    String text = buffer.getLineText(match.startLine).trim();
    if (backward && match.startLine != 0 && text.length() == 1) {
        switch(text.charAt(0)) {
            case '{':
            case '}':
            case '[':
            case ']':
            case '(':
            case ')':
                text = buffer.getLineText(match.startLine - 1).trim() + ' ' + text;
                break;
        }
    }
    // get rid of embedded tabs not removed by trim()
    fireBracketSelected(match.startLine + 1, text.replace('\t', ' '));
}