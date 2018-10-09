// }}}
// {{{ toArray()
/** @return an array of String */
@Override
public String[] toArray() {
    int siz = size();
    String[] result = new String[siz];
    System.arraycopy(super.toArray(), 0, result, 0, siz);
    return result;
}