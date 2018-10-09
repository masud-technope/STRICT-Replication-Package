/* Call this to reinitialize the node stack.  It is called
     automatically by the parser's ReInit() method. */
void reset() {
    nodes.removeAllElements();
    marks.removeAllElements();
    sp = 0;
    mk = 0;
}