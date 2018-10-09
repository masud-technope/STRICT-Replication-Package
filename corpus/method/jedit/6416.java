public String toString() {
    StringBuilder sb = new StringBuilder();
    if (buffers.size() == 0) {
        sb.append("\"Untitled-1\" buffer ");
    } else {
        for (int i = 0; i < buffers.size(); i++) {
            sb.append('\"').append(buffers.get(i)).append('\"');
            sb.append(i == 0 ? " buffer " : " buff ");
        }
    }
    if (scope == null) {
        scope = "view";
    }
    sb.append('\"').append(scope).append("\" bufferset");
    return sb.toString();
}