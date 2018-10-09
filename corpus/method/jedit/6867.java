//}}}
//{{{ contentInserted() method
void contentInserted(int startLine, int numLines) {
    if (numLines != 0) {
        int index = search(startLine);
        int start = index + 1;
        for (int i = start; i < fvmcount; i++) fvm[i] += numLines;
        lastfvmget = -1;
        dump();
    }
}