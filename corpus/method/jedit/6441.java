//}}}
//{{{ snippetBeforeLineOffset() method
/**
	 * Returns a shorten uninitialized chunk before specific offset.
	 * The offset is it in the line text, instead of in chunk.
	 */
final Chunk snippetBeforeLineOffset(int lineOffset) {
    return snippetBefore(lineOffset - this.offset);
}