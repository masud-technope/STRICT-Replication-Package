public static void main(String args[]) throws Exception {
    if (args.length < 2) {
        System.out.println("usage: Remote URL(http|bsh) file [ file ] ... ");
        System.exit(1);
    }
    String url = args[0];
    String text = getFile(args[1]);
    int ret = eval(url, text);
    System.exit(ret);
}