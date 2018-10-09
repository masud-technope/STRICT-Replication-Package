//{{{ Package-private members
//{{{ getText() method
@Override
void getText(JEditBuffer buffer, StringBuilder buf) {
    buf.append(buffer.getText(start, end - start));
//}}}
}