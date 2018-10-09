public int compare(Result r1, Result r2) {
    if (r1.rank == r2.rank)
        return r1.title.compareTo(r2.title);
    else
        return r2.rank - r1.rank;
}