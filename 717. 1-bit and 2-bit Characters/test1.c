bool isOneBitCharacter(int* bits, int bitsSize) {
    int i = 0;
    
    while(i < (bitsSize)) {
        if(bits[i] == 1) {
            i += 2;
            if(i == (bitsSize - 2) && bits[i] == 1 || i == (bitsSize))
                return false;
        }
        else
            i += 1;
    } 
    return true;
}
