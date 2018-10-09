public boolean equals(Object o) {
    if (o instanceof HelpFile)
        return ((HelpFile) o).file.equals(file);
    else
        return false;
}