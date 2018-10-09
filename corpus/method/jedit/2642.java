//{{{ LineManager constructor
public  LineManager() {
    endOffsets = new int[1];
    endOffsets[0] = 1;
    foldLevels = new short[1];
    lineContext = new TokenMarker.LineContext[1];
    lineCount = 1;
}