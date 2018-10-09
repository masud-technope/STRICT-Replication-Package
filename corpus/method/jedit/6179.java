//}}}
//{{{ equals() method
public boolean equals(Object compareObj) {
    if (!(compareObj instanceof HyperSearchResult))
        return false;
    HyperSearchResult otherResult = (HyperSearchResult) compareObj;
    return pathEquals(otherResult.path) && line == otherResult.line && buffer.equals(otherResult.buffer);
}