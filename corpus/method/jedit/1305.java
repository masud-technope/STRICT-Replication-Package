ClassLoader getLoaderForClass(String name) {
    return (ClassLoader) loaderMap.get(name);
}