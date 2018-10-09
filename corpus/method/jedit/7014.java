@Override
public Object clone() {
    CharIterator newOne = new CharIterator(sequence);
    newOne.index = index;
    return newOne;
}