//}}}
//{{{ resetWords() method
private void resetWords(String newWord) {
    int caret = textArea.getCaretPosition();
    Completion[] completions = getCompletions(buffer, newWord, caret);
    if (completions.length > 0) {
        word = newWord;
        reset(new Words(completions), true);
    } else {
        dispose();
    }
}