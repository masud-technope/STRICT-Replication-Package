public  Margins(float top, float left, float right, float bottom) {
    if (top < 0.0 || left < 0.0 || right < 0.0 || bottom < 0.0) {
        // only accept positive numbers
        throw new IllegalArgumentException("Invalid margin.");
    }
    float u = Integer.valueOf(getUnits()).floatValue();
    this.top = top * u;
    this.left = left * u;
    this.right = right * u;
    this.bottom = bottom * u;
}