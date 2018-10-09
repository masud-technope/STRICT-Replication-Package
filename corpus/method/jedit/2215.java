public  ParserTokenManager(JavaCharStream stream) {
    if (JavaCharStream.staticFlag)
        throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
    input_stream = stream;
}