//}}}
//{{{ lookupWord() method
public Word lookupWord(String word) {
    Object o = words.get(word);
    if (o == IGNORE)
        return null;
    else
        return (Word) o;
}