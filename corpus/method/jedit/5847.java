//{{{ addOperation() method
private void addOperation(Operation op) {
    for (Operation operation : operations) {
        if (operation.equals(op))
            return;
    }
    operations.add(op);
}