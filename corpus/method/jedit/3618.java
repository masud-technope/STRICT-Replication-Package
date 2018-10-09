//{{{ HistoryText constructor
public  HistoryText(JTextComponent text, String name) {
    this.text = text;
    setModel(name);
    index = -1;
}