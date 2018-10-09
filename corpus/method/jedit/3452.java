/**
	  * Redistributs free space (positive or negative) to all available
	  * columns or rows while taking elements maximum and minimum sizes into
	  * account if possible.
	  *
	  * @param totalSize             The cumulated preferred sizes of the components
	  * @param freeSize              The available space for displaying components
	  *                              without any gaps between components or between
	  *                              the grid and the borders of the parent container
	  * @param start                 The start in the arrays of rows or columns inclusive
	  * @param stop                  The stop in the arrays of rows or columns exclusive
	  * @param preferredElementSizes The preferredSizes of the rows or columns.
	  *                              After invocation of this method, this array
	  *                              holds the sizes that should be used
	  * @param minimumElementSizes   The minimumSizes of the rows or columns
	  * @param maximumElementSizes   The maximumSizes of the rows or columns
	  */
private void redistributeSpace(int totalSize, int freeSize, int start, int stop, int[] preferredElementSizes, int[] minimumElementSizes, int[] maximumElementSizes) {
    if (totalSize != freeSize) {
        boolean grow = totalSize < freeSize;
        // calculate the size that is available for redistribution
        freeSize = (freeSize - totalSize) * (grow ? 1 : -1);
        while (freeSize > 0) {
            // calculate the amount of elements that can be resized without violating
            // the minimum and maximum sizes and their current cumulated size
            int modifyableAmount = 0;
            long modifySize = 0;
            for (int i = start; i < stop; i++) {
                if ((grow && (preferredElementSizes[i] < maximumElementSizes[i])) || (!grow && (preferredElementSizes[i] > minimumElementSizes[i]))) {
                    modifyableAmount++;
                    modifySize += preferredElementSizes[i];
                }
            }
            boolean checkBounds = true;
            // if all elements are at their minimum or maximum size, resize all elements
            if (0 == modifyableAmount) {
                for (int i = start; i < stop; i++) {
                    modifySize += preferredElementSizes[i];
                }
                checkBounds = false;
                modifyableAmount = stop - start;
            }
            // to prevent an endless loop if the container gets resized to a very small amount
            if (modifySize == 0) {
                break;
            }
            // resize the elements
            if (freeSize < modifyableAmount) {
                for (int i = start; i < stop; i++) {
                    if ((freeSize != 0) && (!checkBounds || (checkBounds && (grow && (preferredElementSizes[i] < maximumElementSizes[i])) || (!grow && (preferredElementSizes[i] > minimumElementSizes[i]))))) {
                        preferredElementSizes[i] += (grow ? 1 : -1);
                        if (0 > preferredElementSizes[i]) {
                            preferredElementSizes[i] = 0;
                        }
                        freeSize--;
                    }
                }
            } else {
                long modifySizeAddition = 0;
                double factor = (double) (freeSize + modifySize) / (double) modifySize;
                for (int i = start; i < stop; i++) {
                    long modifyableSize = (checkBounds ? (grow ? maximumElementSizes[i] - preferredElementSizes[i] : preferredElementSizes[i] - minimumElementSizes[i]) : Integer.MAX_VALUE - preferredElementSizes[i]);
                    long elementModifySize = Math.abs(Math.round((factor * preferredElementSizes[i]) - preferredElementSizes[i]));
                    if (elementModifySize <= modifyableSize) {
                        preferredElementSizes[i] += (grow ? elementModifySize : -elementModifySize);
                        modifySizeAddition += (grow ? elementModifySize : -elementModifySize);
                        freeSize -= elementModifySize;
                    } else {
                        preferredElementSizes[i] += (grow ? modifyableSize : -modifyableSize);
                        modifySizeAddition += (grow ? modifyableSize : -modifyableSize);
                        freeSize -= modifyableSize;
                    }
                    if (0 > preferredElementSizes[i]) {
                        preferredElementSizes[i] = 0;
                    }
                }
                modifySize += modifySizeAddition;
            }
        }
    }
}