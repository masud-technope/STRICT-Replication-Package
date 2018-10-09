public void complete(int index) {
    String insertion = completions[index].toString().substring(word.length());
    textArea.replaceSelection(insertion);
}