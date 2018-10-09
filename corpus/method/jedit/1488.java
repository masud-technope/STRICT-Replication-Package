void openNodeScope(Node n) {
    marks.push(Integer.valueOf(mk));
    mk = sp;
    n.jjtOpen();
}