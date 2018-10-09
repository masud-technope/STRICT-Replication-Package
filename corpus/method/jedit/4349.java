//}}}
//{{{ indexStream() method
/**
	 * Reads the specified HTML file and adds all words defined therein to the
	 * index.
	 * @param _in The input stream
	 * @param fileName The file
	 */
private void indexStream(InputStream _in, String fileName) throws Exception {
    HelpFile file = new HelpFile(fileName);
    files.add(file);
    int index = files.size() - 1;
    StringBuilder titleText = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(_in));
    try {
        StringBuilder word = new StringBuilder();
        boolean insideTag = false;
        boolean insideEntity = false;
        boolean title = false;
        int c;
        while ((c = in.read()) != -1) {
            char ch = (char) c;
            if (insideTag) {
                if (ch == '>') {
                    if (word.toString().equals("title"))
                        title = true;
                    insideTag = false;
                    word.setLength(0);
                } else
                    word.append(ch);
            } else if (insideEntity) {
                if (ch == ';')
                    insideEntity = false;
            } else if (ch == '<') {
                if (title)
                    title = false;
                if (word.length() != 0) {
                    addWord(word.toString(), index, title);
                    word.setLength(0);
                }
                insideTag = true;
            } else if (ch == '&')
                insideEntity = true;
            else if (title)
                titleText.append(ch);
            else if (!Character.isLetterOrDigit(ch)) {
                if (word.length() != 0) {
                    addWord(word.toString(), index, title);
                    word.setLength(0);
                }
            } else
                word.append(ch);
        }
    } finally {
        in.close();
    }
    if (titleText.length() == 0)
        file.title = fileName;
    else
        file.title = titleText.toString();
}