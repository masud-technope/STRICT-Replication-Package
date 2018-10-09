public String toString(int units) {
    String uom = "";
    switch(units) {
        case INCH:
            uom = "in";
            break;
        case MM:
            uom = "mm";
            break;
        default:
            throw new IllegalArgumentException("Invalid units.");
    }
    float[] margins = getMargins(units);
    StringBuilder sb = new StringBuilder(128);
    sb.append("Margins(").append(uom).append(")[top:").append(margins[0]).append(", left:");
    sb.append(margins[1]).append(", right:").append(margins[2]).append(", bottom:").append(margins[3]).append(']');
    return sb.toString();
}