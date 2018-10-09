// A workaround for a restriction of super().
private  Saver(File twoStageSaveFile) throws IOException {
    super(new OutputStreamWriter(new FileOutputStream(twoStageSaveFile), encoding));
    this.twoStageSaveFile = twoStageSaveFile;
}