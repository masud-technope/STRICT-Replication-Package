// this can be called multiple times by the print system for the same page, and
// all calls must be handled for the page to print properly. 
public int print(Graphics _gfx, PageFormat pageFormat, int pageIndex) throws PrinterException {
    // pageIndex is 0-based, but pages are 1-based
    pageIndex += 1;
    //Log.log(Log.DEBUG, this, "Asked to print page " + pageIndex);
    if (firstCall && pages == null) {
        pages = calculatePages(_gfx, pageFormat);
        if (pages == null || pages.isEmpty()) {
            throw new PrinterException("Unable to determine page ranges.");
        }
        firstCall = false;
    }
    // adjust the page index for reverse printing
    if (reverse && !PrintRangeType.CURRENT_PAGE.equals(printRangeType)) {
        pageIndex = pages.size() - 1 - pageIndex;
    //Log.log(Log.DEBUG, this, "Reverse is on, changing page index to " + pageIndex);
    }
    // go ahead and print the page
    Range range = pages.get(pageIndex);
    //Log.log(Log.DEBUG, this, "range = " + range);
    if ((range == null || !inRange(pageIndex)) && !PrintRangeType.CURRENT_PAGE.equals(printRangeType)) {
        //Log.log(Log.DEBUG, this, "Returning NO_SUCH_PAGE for page " + pageIndex);
        return NO_SUCH_PAGE;
    } else {
        printPage(_gfx, pageFormat, pageIndex, true);
    }
    //Log.log(Log.DEBUG, this, "Returning PAGE_EXISTS for page " + pageIndex);
    return PAGE_EXISTS;
}