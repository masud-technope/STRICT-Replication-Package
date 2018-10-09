/**
     * Determine if the two entries are equal. Equality is determined
     * by the header names being equal.
     *
     * @param it Entry to be checked for equality.
     * @return True if the entries are equal.
     */
public boolean equals(ArEntry it) {
    return this.getFilename().equals(it.getFilename());
}