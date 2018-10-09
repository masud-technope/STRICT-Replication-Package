//{{{ equals() method
public boolean equals(HistoryEntry he) {
    return he.url.equals(this.url) && he.title.equals(this.title) && (he.scrollPosition == scrollPosition);
//}}}
}