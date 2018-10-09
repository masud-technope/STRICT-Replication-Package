 Favorite(String path, int type) {
    super(path, path, PROTOCOL + ':' + path, type, 0L, false);
    this.label = MiscUtilities.abbreviateView(path);
}