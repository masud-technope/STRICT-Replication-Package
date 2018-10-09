//}}}
//{{{ invokeReadNextChar() method
protected void invokeReadNextChar(char ch) {
    String charStr = StandardUtilities.charsToEscapes(String.valueOf(ch));
    // this might be a bit slow if __char__ occurs a lot
    int index;
    while ((index = readNextChar.indexOf("__char__")) != -1) {
        readNextChar = readNextChar.substring(0, index) + '\'' + charStr + '\'' + readNextChar.substring(index + 8);
    }
    readNextChar = null;
}