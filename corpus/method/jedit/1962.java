public static void main(String[] args) throws IOException, ParseException {
    boolean print = false;
    int i = 0;
    if (args[0].equals("-p")) {
        i++;
        print = true;
    }
    for (; i < args.length; i++) {
        Reader in = new FileReader(args[i]);
        Parser parser = new Parser(in);
        parser.setRetainComments(true);
        while (!parser.Line()) /*eof*/
        if (print)
            System.out.println(parser.popNode());
    }
}