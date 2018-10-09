public void add(URL[] urls) {
    path.addAll(Arrays.asList(urls));
    if (mapsInitialized)
        map(urls);
}