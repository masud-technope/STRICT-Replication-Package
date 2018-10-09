//{{{ ChunkCache constructor
 ChunkCache(TextArea textArea) {
    this.textArea = textArea;
    outFull = new ArrayList<Chunk>();
    outFullPhysicalLine = -1;
    tokenHandler = new DisplayTokenHandler();
}