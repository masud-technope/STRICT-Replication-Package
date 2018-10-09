public String toString() {
    StringBuilder sb = new StringBuilder("PageRangeType: ");
    switch(getValue()) {
        case 0:
            sb.append("0 ALL");
            break;
        case 1:
            sb.append("1 ODD");
            break;
        case 2:
            sb.append("2 EVEN");
            break;
        case 3:
            sb.append("3 RANGE");
            break;
        case 4:
            sb.append("4 CURRENT_PAGE");
            break;
        case 6:
            sb.append("5 SELECTION");
            break;
    }
    return sb.toString();
}