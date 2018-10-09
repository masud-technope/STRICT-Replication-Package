@Override
public int compare(E obj1, E obj2) {
    return compareStrings(obj1.toString(), obj2.toString(), icase);
}