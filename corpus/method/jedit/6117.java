//}}}
//{{{ getSkipIndex() method
/*
	 *  to avoid our skip table having a length of 2 ^ 16, we hash each
	 *  character of the input into a character in the alphabet [\x00-\xFF]
	 *  using the lower 8 bits of the character's value (resulting in
	 *  a more reasonable skip table of length 2 ^ 8).
	 *
	 *  the result of this is that more than one character can hash to the
	 *  same index, but since the skip table encodes the position of
	 *  occurence of the character furthest into the string with a particular
	 *  index (whether or not it is the only character with that index), an
	 *  index collision only means that that this heuristic will give a
	 *  sub-optimal skip (i.e. a complete skip table could use the differences
	 *  between colliding characters to maximal effect, at the expense of
	 *  building a table that is over 2 orders of magnitude larger and very
	 *  sparse).
	 */
private static int getSkipIndex(char ch) {
    return ch & 0x000000FF;
}