 Word(String word, int file, boolean title) {
    this.word = word;
    occurrences = new Occurrence[5];
    addOccurrence(file, title);
}