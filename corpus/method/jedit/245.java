/**
     * Is the archive up to date in relationship to a list of files.
     * @param files the files to check
     * @param dir   the base directory for the files.
     * @return true if the archive is up to date.
     */
protected boolean archiveIsUpToDate(String[] files, File dir) {
    SourceFileScanner sfs = new SourceFileScanner(this);
    MergingMapper mm = new MergingMapper();
    mm.setTo(destFile.getAbsolutePath());
    return sfs.restrict(files, dir, null, mm).length == 0;
}