//{{{ contentInserted() method
@Override
boolean contentInserted(JEditBuffer buffer, int startLine, int start, int numLines, int length) {
    boolean changed = false;
    if (this.start >= start) {
        this.start += length;
        if (numLines != 0)
            this.startLine = buffer.getLineOfOffset(this.start);
        changed = true;
    }
    if (this.end >= start) {
        this.end += length;
        if (numLines != 0)
            this.endLine = buffer.getLineOfOffset(this.end);
        changed = true;
    }
    return changed;
//}}}
}