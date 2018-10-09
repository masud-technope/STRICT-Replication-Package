public boolean equals(Object o) {
    if (o instanceof ErrorEntry) {
        ErrorEntry e = (ErrorEntry) o;
        return e.path.equals(path);
    } else
        return false;
}