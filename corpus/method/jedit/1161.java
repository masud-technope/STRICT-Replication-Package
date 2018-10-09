public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CallStack:\n");
    NameSpace[] nsa = toArray();
    for (int i = 0; i < nsa.length; i++) sb.append("\t" + nsa[i] + "\n");
    return sb.toString();
}