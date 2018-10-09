//}}}
//{{{ addWord() method
private void addWord(String word, int file, boolean title) {
    word = word.toLowerCase();
    Object o = words.get(word);
    if (o == IGNORE)
        return;
    if (o == null)
        words.put(word, new Word(word, file, title));
    else
        ((Word) o).addOccurrence(file, title);
}