/**
	 * Determine if the two entries are equal. Equality is determined
	 * by the header names being equal.
	 *
	 * @return it Entry to be checked for equality.
	 * @return True if the entries are equal.
	 */
public boolean equals(TarEntry it) {
    return this.header.name.toString().equals(it.header.name.toString());
}