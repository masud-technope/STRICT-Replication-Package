public BshMethod get() throws java.lang.Exception {
    if (cache != null) {
        BshMethod cached = cache.get();
        if (cached != null) {
            return cached;
        }
    }
    BshMethod newOne = BeanShell.cacheBlock(name, source, true);
    cache = new SoftReference<BshMethod>(newOne);
    return newOne;
}