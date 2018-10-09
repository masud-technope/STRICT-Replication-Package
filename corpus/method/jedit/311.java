protected boolean packageIsUpToDate(String[] files, File dir) {
    SourceFileScanner sfs = new SourceFileScanner(this);
    MergingMapper mm = new MergingMapper();
    mm.setTo(destFile.getAbsolutePath());
    return sfs.restrict(files, dir, null, mm).length == 0;
}