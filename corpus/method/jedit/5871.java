//}}}
//{{{ print() method
public int print(Graphics _gfx, PageFormat pageFormat, int pageIndex) throws PrinterException {
    // we get invalid ones on subsequent pages on Windows
    if (frc == null) {
        frc = ((Graphics2D) _gfx).getFontRenderContext();
    //Log.log(Log.DEBUG,this,"Font render context is " + frc);
    }
    if (pageIndex > currentPage) {
        for (int i = currentPage; i < pageIndex; i++) {
            //Log.log(Log.DEBUG,this,"Current physical line is now " + currentPageStart);
            currentPhysicalLine = currentPageStart;
            printPage(_gfx, pageFormat, i, true);
        }
        currentPage = pageIndex - 1;
    //Log.log(Log.DEBUG,this,"Current page is now " + currentPage);
    }
    if (pageIndex == currentPage + 1) {
        if (end) {
            //Log.log(Log.DEBUG,this,"The end");
            return NO_SUCH_PAGE;
        }
        currentPageStart = currentPhysicalLine;
        //Log.log(Log.DEBUG,this,"#2 - Current physical line is now " + currentPageStart);
        currentPage = pageIndex;
    //Log.log(Log.DEBUG,this,"#2 - Current page is now " + currentPage);
    } else if (pageIndex == currentPage) {
        currentPhysicalLine = currentPageStart;
    //Log.log(Log.DEBUG,this,"#3 - Current physical line is now " + currentPageStart);
    }
    printPage(_gfx, pageFormat, pageIndex, true);
    return PAGE_EXISTS;
}