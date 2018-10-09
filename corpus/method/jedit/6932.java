//{{{ contentRemoved() method
@Override
boolean contentRemoved(JEditBuffer buffer, int startLine, int start, int numLines, int length) {
    int end = start + length;
    boolean changed = false;
    if (this.start > start && this.start <= end) {
        this.start = start;
        changed = true;
    } else if (this.start > end) {
        this.start -= length;
        changed = true;
    }
    if (this.end > start && this.end <= end) {
        this.end = start;
        changed = true;
    } else if (this.end > end) {
        this.end -= length;
        changed = true;
    }
    if (changed && numLines != 0) {
        this.startLine = buffer.getLineOfOffset(this.start);
        this.endLine = buffer.getLineOfOffset(this.end);
    }
    return changed;
//}}}
}