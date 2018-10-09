// finds the intersection of the pages selected in the General tab (All pages
// or a page range) with the all, odd, or even setting for the 'only print'
// setting in the Page Setup tab.
private PageRanges mergeRanges(PageRanges pr) throws PrintException {
    if (pr == null || onlyPrintPages == PrintRangeType.ALL.getValue()) {
        return pr;
    }
    List<Integer> pages = new ArrayList<Integer>();
    int[][] ranges = pr.getMembers();
    for (int i = 0; i < ranges.length; i++) {
        int[] range = ranges[i];
        int start = range[0];
        // this limits printing to the first 250 pages. If the user selects 'All pages'
        // from the General tab, then the range is 1 to Integer.MAX_VALUE, so to print just
        // the even or odd numbered pages would need an array of 1073741823 values, which
        // is unreasonable.
        int end = range.length == 1 ? range[0] : Math.min(range[0] + 500, range[1]);
        for (int pageIndex = start; pageIndex <= end; pageIndex++) {
            if (pageIndex % 2 == 0 && onlyPrintPages == PrintRangeType.EVEN.getValue()) {
                pages.add(pageIndex);
            } else if (pageIndex % 2 == 1 && onlyPrintPages == PrintRangeType.ODD.getValue()) {
                pages.add(pageIndex);
            }
        }
    }
    if (pages.isEmpty()) {
        throw new PrintException("No pages are selected to print.\nPlease check the 'Range' setting on the General tab and\nthe 'Only print' setting on the Page Setup tab.");
    }
    StringBuilder sb = new StringBuilder();
    for (Integer page : pages) {
        sb.append(page).append(',');
    }
    sb.deleteCharAt(sb.length() - 1);
    return new PageRanges(sb.toString());
}