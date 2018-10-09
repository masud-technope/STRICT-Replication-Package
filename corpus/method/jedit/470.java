public  DirVerifier(JComponent parent, Object pos) {
    super();
    message = new JTextArea(" ");
    message.setEditable(false);
    message.setBackground(parent.getBackground());
    this.parent = parent;
    this.pos = pos;
}