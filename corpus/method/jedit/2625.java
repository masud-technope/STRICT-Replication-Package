//}}}
//}}}
//{{{ Package-private members
//{{{ changed() method
void changed(String oldStr, String newStr) {
    int i = indexOf(oldStr);
    if (i != -1)
        ring[i] = newStr;
    else
        add(newStr);
}