//}}}
//{{{ reset() method
void reset(int lines) {
    lastfvmget = -1;
    fvmcount = 2;
    fvm[0] = 0;
    fvm[1] = lines;
}