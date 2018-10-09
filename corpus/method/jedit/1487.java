/* Returns the node on the top of the stack, and remove it from the
     stack.  */
Node popNode() {
    if (--sp < mk) {
        mk = ((Integer) marks.pop()).intValue();
    }
    return (Node) nodes.pop();
}