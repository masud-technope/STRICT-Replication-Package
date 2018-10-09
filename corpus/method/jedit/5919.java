/**
     * Get the margins as an array of 4 values in the order
     * top, left, right, bottom. The values returned are in the given units.
     * @param  units Unit conversion factor, either INCH or MM.
     *
     * @return margins as array of top, left, right, bottom in the specified units.
     *
     * @exception  IllegalArgumentException on invalid units.
     */
public float[] getMargins(int units) {
    switch(units) {
        case INCH:
        case MM:
            break;
        default:
            throw new IllegalArgumentException("Invalid units.");
    }
    return new float[] { getTop(units), getLeft(units), getRight(units), getBottom(units) };
}