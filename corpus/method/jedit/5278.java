//{{{ add() method
void add(String abbrev, String expansion) {
    abbrevs.add(new Abbrev(abbrev, expansion));
    sort(lastSort);
//}}}
}