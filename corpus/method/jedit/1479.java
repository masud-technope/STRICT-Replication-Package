/* Returns the number of children on the stack in the current node
     scope. */
int nodeArity() {
    return sp - mk;
}