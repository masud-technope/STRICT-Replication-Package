private void redistributeSpace(int total_size, int free_size, boolean takeSizesIntoAccount, int nelements, int[] element_sizes, int[] minimum_element_sizes, int[] maximum_element_sizes) {
    if (total_size != free_size) {
        if (takeSizesIntoAccount) {
            boolean grow = total_size < free_size;
            // calculate the size that is available for redistribution
            free_size = (free_size - total_size) * (grow ? 1 : -1);
            while (free_size != 0) {
                // calculate the amount of elements that can be resized without violating
                // the minimum and maximum sizes and their current cumulated size
                int modifyableAmount = 0;
                int modifySize = 0;
                for (int i = 0; i < nelements; i++) {
                    if ((grow && (element_sizes[i] < maximum_element_sizes[i])) || (!grow && (element_sizes[i] > minimum_element_sizes[i]))) {
                        modifyableAmount++;
                        modifySize += element_sizes[i];
                    }
                }
                boolean checkBounds = true;
                // if all elements are at their minimum or maximum size, resize all elements
                if (0 == modifyableAmount) {
                    for (int i = 0; i < nelements; i++) {
                        modifySize += element_sizes[i];
                    }
                    checkBounds = false;
                    modifyableAmount = nelements;
                }
                // to prevent an endless loop if the container gets resized to a very small amount
                if (modifySize == 0) {
                    break;
                }
                // resize the elements
                if (free_size < modifyableAmount) {
                    for (int i = 0; i < nelements; i++) {
                        if ((free_size != 0) && (!checkBounds || (checkBounds && (grow && (element_sizes[i] < maximum_element_sizes[i])) || (!grow && (element_sizes[i] > minimum_element_sizes[i]))))) {
                            element_sizes[i] += (grow ? 1 : -1);
                            if (0 > element_sizes[i]) {
                                element_sizes[i] = 0;
                            }
                            free_size--;
                        }
                    }
                } else {
                    int modifySizeAddition = 0;
                    for (int i = 0; i < nelements; i++) {
                        int modifyableSize = (checkBounds ? (grow ? maximum_element_sizes[i] - element_sizes[i] : element_sizes[i] - minimum_element_sizes[i]) : Integer.MAX_VALUE - element_sizes[i]);
                        int elementModifySize = (int) ((double) free_size / (double) modifySize * (double) element_sizes[i]);
                        if (elementModifySize <= modifyableSize) {
                            element_sizes[i] += (grow ? elementModifySize : -elementModifySize);
                            modifySizeAddition += (grow ? elementModifySize : -elementModifySize);
                            free_size -= elementModifySize;
                        } else {
                            element_sizes[i] += (grow ? modifyableSize : -modifyableSize);
                            modifySizeAddition += (grow ? modifyableSize : -modifyableSize);
                            free_size -= modifyableSize;
                        }
                        if (0 > element_sizes[i]) {
                            element_sizes[i] = 0;
                        }
                    }
                    modifySize += modifySizeAddition;
                }
            }
        } else {
            double d = (double) free_size / (double) total_size;
            for (int i = 0; i < nelements; i++) {
                element_sizes[i] = (int) (element_sizes[i] * d);
            }
        }
    }
}