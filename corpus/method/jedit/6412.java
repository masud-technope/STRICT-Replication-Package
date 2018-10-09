public String toString() {
    StringBuilder sb = new StringBuilder();
    if (left != null) {
        sb.append(left.toString()).append(' ');
    }
    if (right != null) {
        sb.append(right.toString()).append(' ');
    }
    sb.append(offset).append(' ').append(direction);
    return sb.toString();
}