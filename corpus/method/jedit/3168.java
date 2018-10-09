//{{{ CompleteWord constructor
public  CompleteWord(View view, String word, Completion[] completions, Point location, String noWordSep) {
    super(view, location);
    this.noWordSep = noWordSep;
    this.view = view;
    this.textArea = view.getTextArea();
    this.buffer = view.getBuffer();
    this.word = word;
    reset(new Words(completions), true);
}