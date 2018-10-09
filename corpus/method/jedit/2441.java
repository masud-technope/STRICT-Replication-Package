private void toString(StringBuilder sb) {
    sb.append(data, offset, len);
    if (next != null)
        next.toString(sb);
}