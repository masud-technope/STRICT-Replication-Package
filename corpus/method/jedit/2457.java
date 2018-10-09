//}}}
//{{{ _setContent() method
public void _setContent(char[] text, int length) {
    assert text != null;
    assert text.length >= length;
    this.text = text;
    this.gapStart = length;
    this.length = length;
}