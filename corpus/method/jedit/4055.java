//{{{ update() method
public void update() {
    Buffer buffer = view.getBuffer();
    String lineSep = buffer.getStringProperty(JEditBuffer.LINESEP);
    if ("\n".equals(lineSep))
        this.lineSep.setText("U");
    else if ("\r\n".equals(lineSep))
        this.lineSep.setText("W");
    else if ("\r".equals(lineSep))
        this.lineSep.setText("M");
//}}}
}