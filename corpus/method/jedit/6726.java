//}}}
//{{{ _expandFold() method
/**
	 * Expands the fold at the specified physical line index.
	 * @param line A physical line index
	 * @param fully If true, all subfolds will also be expanded
	 * @param firstSubfold Will be set to the line number of the first
	 * subfold, or -1 if there is none.
	 * @return True if some line was unfolded, false otherwise.
	 */
private boolean _expandFold(int line, boolean fully, MutableInteger firstSubfold) {
    boolean unfolded = false;
    int lineCount = buffer.getLineCount();
    int end = lineCount - 1;
    while (!isLineVisible(line)) {
        int prevLine = folds.lookup(folds.search(line)) - 1;
        if (!isLineVisible(prevLine)) {
            return unfolded;
        }
        // If any fold farther up was unfolded, then the text
        // area needs to be updated
        unfolded |= _expandFold(prevLine, fully, firstSubfold);
        if (!isLineVisible(prevLine + 1)) {
            return unfolded;
        }
    }
    // still need to look for and show its subfolds.
    if (line == (lineCount - 1) || (isLineVisible(line + 1) && !fully)) {
        return unfolded;
    }
    //{{{ Find fold start and fold end...
    int start;
    int initialFoldLevel = buffer.getFoldLevel(line);
    if (buffer.getFoldLevel(line + 1) > initialFoldLevel) {
        // this line is the start of a fold
        start = line;
        if (!isLineVisible(line + 1) && folds.search(line + 1) != folds.count() - 1) {
            int index = folds.search(line + 1);
            end = folds.lookup(index + 1) - 1;
        } else {
            for (int i = line + 1; i < lineCount; i++) {
                if (buffer.getFoldLevel(i) <= initialFoldLevel) {
                    end = i - 1;
                    break;
                }
            }
        }
    } else {
        if (!fully) {
            return unfolded;
        }
        start = line;
        while (start > 0 && buffer.getFoldLevel(start) >= initialFoldLevel) {
            start--;
        }
        initialFoldLevel = buffer.getFoldLevel(start);
        for (int i = line + 1; i < lineCount; i++) {
            if (buffer.getFoldLevel(i) <= initialFoldLevel) {
                end = i - 1;
                break;
            }
        }
    // }}}
    }
    //{{{ Expand the fold...
    if (fully) {
        showLineRange(start, end);
    } else {
        boolean foundSubfold = false;
        for (int i = start + 1; i <= end; ) {
            if (!foundSubfold && buffer.isFoldStart(i)) {
                firstSubfold.set(i);
                foundSubfold = true;
            }
            showLineRange(i, i);
            int fold = buffer.getFoldLevel(i);
            i++;
            while (i <= end && buffer.getFoldLevel(i) > fold) {
                i++;
            }
        }
    }
    unfolded = true;
    // }}}
    notifyScreenLineChanges();
    return unfolded;
}