public boolean equals(Object object) {
    boolean toReturn = false;
    if (object instanceof Margins) {
        Margins margins = (Margins) object;
        if (top == margins.top && left == margins.left && bottom == margins.bottom && right == margins.right) {
            toReturn = true;
        }
    }
    return toReturn;
}