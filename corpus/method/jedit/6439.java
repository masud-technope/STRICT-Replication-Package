//}}}
//{{{ snippetBefore() method
/**
	 * Returns a shorten uninitialized chunk before specific offset.
	 */
final Chunk snippetBefore(int snipOffset) {
    assert 0 <= snipOffset && snipOffset < length;
    return new Chunk(id, offset, snipOffset, rules, style, background);
}