@Override
protected boolean removeEldestEntry(Map.Entry<GlyphKey, GlyphVector[]> eldest) {
    return size() > capacity;
}