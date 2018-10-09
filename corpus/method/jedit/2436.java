public int length() {
    return len + ((next != null) ? next.length() : 0);
}