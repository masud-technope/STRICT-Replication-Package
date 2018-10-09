//{{{ HelpIndex constructor
public  HelpIndex() {
    words = new HashMap<String, Object>();
    files = new ArrayList<HelpFile>();
    ignoreWord("a");
    ignoreWord("an");
    ignoreWord("and");
    ignoreWord("are");
    ignoreWord("as");
    ignoreWord("be");
    ignoreWord("by");
    ignoreWord("can");
    ignoreWord("do");
    ignoreWord("for");
    ignoreWord("from");
    ignoreWord("how");
    ignoreWord("i");
    ignoreWord("if");
    ignoreWord("in");
    ignoreWord("is");
    ignoreWord("it");
    ignoreWord("not");
    ignoreWord("of");
    ignoreWord("on");
    ignoreWord("or");
    ignoreWord("s");
    ignoreWord("that");
    ignoreWord("the");
    ignoreWord("this");
    ignoreWord("to");
    ignoreWord("will");
    ignoreWord("with");
    ignoreWord("you");
}