public NameSpace[] toArray() {
    NameSpace[] nsa = new NameSpace[depth()];
    stack.copyInto(nsa);
    return nsa;
}