// }}}
// {{{ main()
public static void main(String args[]) {
    String teststr = "a,b,c,d,e,f";
    StringList.split(teststr, ",");
    //String joinstr = sl.join(",");
    // assert(teststr.equals(joinstr));
    System.out.println("Test Passed");
}