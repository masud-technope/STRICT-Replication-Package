 Entry(VFSFile dirEntry, int level) {
    this.dirEntry = dirEntry;
    this.level = level;
    this.extension = MiscUtilities.getFileExtension(dirEntry.getName());
}