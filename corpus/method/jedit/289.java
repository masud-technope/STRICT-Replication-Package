public void setLongFileMode(int longFileMode) {
    if (writingStarted) {
        throw new IllegalStateException("longFileMode cannot be changed after writing to the archive has begun");
    }
    if (LONGFILE_GNU == longFileMode) {
        throw new UnsupportedOperationException("GNU variant isn't implemented yet");
    }
    if (LONGFILE_BSD == longFileMode) {
        throw new UnsupportedOperationException("BSD variant isn't implemented yet");
    }
    this.longFileMode = longFileMode;
}