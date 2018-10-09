public  GlyphCache(int capacity) {
    // Avoid rehashing with known limit.
    super(capacity + 1, /*accessOrder*/
    1.0f, true);
    this.capacity = capacity;
}