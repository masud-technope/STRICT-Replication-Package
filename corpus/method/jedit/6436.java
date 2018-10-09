@Override
public final boolean equals(Object otherObject) {
    // should be called only from GlyphCache to
    // compare with other keys, then explicit type
    // checking and null checking are not necessary.
    GlyphKey other = (GlyphKey) otherObject;
    return token.equals(other.token) && font.equals(other.font) && context.equals(other.context);
}