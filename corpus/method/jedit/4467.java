public boolean equals(Object o) {
    if (o instanceof Increase)
        return ((Increase) o).amount == amount;
    else
        return false;
}