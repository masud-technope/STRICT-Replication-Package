//}}}
//{{{ invalidateScreenLineCounts() method
void invalidateScreenLineCounts() {
    for (int i = 0, lineCount = buffer.getLineCount(); i < lineCount; i++) invalidateScreenLineCount(i);
}