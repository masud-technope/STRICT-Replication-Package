//}}}
//{{{ compareTo() method
public int compareTo(Object o) {
    return label.compareTo(((ActionSet) o).label);
}