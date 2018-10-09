public  PrintPreviewModel(View view, Buffer buffer, PrintService printService, PrintRequestAttributeSet attributes, HashMap<Integer, Range> pageRanges) {
    super();
    this.view = view;
    this.buffer = buffer;
    this.printService = printService;
    this.attributes = attributes;
    this.pageRanges = pageRanges;
}