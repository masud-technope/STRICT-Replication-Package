//}}}
//{{{ setFoldLevel() method
// Also sets 'fold level valid' flag
public final void setFoldLevel(int line, int level) {
    if (level > 0xffff) {
        // limitations...
        level = 0xffff;
    }
    foldLevels[line] = (short) level;
}