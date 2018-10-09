//{{{ main() method
public static void main(String[] args) {
    JFrame frame = new JFrame();
    TextArea text = createTextArea();
    Mode mode = new Mode("xml");
    mode.setProperty("file", "modes/xml.xml");
    ModeProvider.instance.addMode(mode);
    text.getBuffer().setMode(mode);
    frame.getContentPane().add(text);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}