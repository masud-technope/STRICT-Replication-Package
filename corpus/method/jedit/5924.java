public int hashCode() {
    return Float.valueOf(top).intValue() + 37 * Float.valueOf(left).intValue() + 43 * Float.valueOf(right).intValue() + 47 * Float.valueOf(bottom).intValue();
}