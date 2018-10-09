//}}}
//{{{ setDimension() method
void setDimension(int dimension) {
    if (dimension > SPLITTER_WIDTH)
        this.dimension = dimension - SPLITTER_WIDTH;
}