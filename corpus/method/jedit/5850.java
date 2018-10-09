//{{{ equals() method
public boolean equals(Object o) {
    return o instanceof Install && ((Install) o).url.equals(url);
//}}}
}