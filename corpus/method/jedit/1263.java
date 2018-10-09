public void add(URL url) throws IOException {
    path.add(url);
    if (mapsInitialized)
        map(url);
}