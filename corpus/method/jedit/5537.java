public boolean equals(Object o) {
    if (o instanceof Button)
        return ((Button) o).actionName.equals(actionName);
    else
        return false;
}