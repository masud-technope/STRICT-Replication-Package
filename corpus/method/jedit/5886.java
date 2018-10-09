// returns true if the given page number is one of the pages requested to
// be printed
private boolean inRange(int pageNumber) {
    PageRanges ranges = (PageRanges) attributes.get(PageRanges.class);
    //Log.log(Log.DEBUG, this, "inRange, ranges = " + ranges);
    boolean answer = false;
    if (ranges == null) {
        answer = true;
    } else {
        answer = ranges.contains(pageNumber);
    }
    //Log.log(Log.DEBUG, this, "inRange(" + pageNumber + ") returning " + answer);
    return answer;
}