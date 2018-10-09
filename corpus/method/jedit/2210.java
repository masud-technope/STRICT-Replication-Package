public  ParserTokenManager(JavaCharStream stream, int lexState) {
    this(stream);
    SwitchTo(lexState);
}