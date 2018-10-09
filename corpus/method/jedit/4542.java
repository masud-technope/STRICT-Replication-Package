@Nonnull
public Reader getPermissiveTextReader(@Nonnull InputStream in) throws IOException {
    // Use REPLACE action to indicate where the coding error
    // happened by the replacement character "\uFFFD".
    CharsetDecoder permissive = body.newDecoder();
    permissive.onMalformedInput(CodingErrorAction.REPLACE);
    permissive.onUnmappableCharacter(CodingErrorAction.REPLACE);
    return new InputStreamReader(in, permissive);
}