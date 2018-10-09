//}}}
//{{{ snippetAfter() method
/**
	 * Returns a shorten uninitialized chunk after specific offset.
	 */
final Chunk snippetAfter(int snipOffset) {
    assert 0 <= snipOffset && snipOffset < length;
    return new Chunk(id, offset + snipOffset, length - snipOffset, rules, style, background);
}