public  Match(StructureMatcher matcher, int startLine, int start, int endLine, int end) {
    this(matcher);
    this.startLine = startLine;
    this.start = start;
    this.endLine = endLine;
    this.end = end;
}