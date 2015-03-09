#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char *name;
    int size;
    void (*(*_vtable)[])();
} metadata;

typedef struct {
    metadata *clazz;
} object;

object *alloc(metadata *clazz) {
    object *p = malloc(clazz->size);
    p->clazz = clazz;
    return p;
}



// D e f i n e  C l a s s  A
typedef struct {
    metadata *clazz;
} A;



void (*A_vtable[])() = {
};

metadata A_metadata = {"A", sizeof(A), &A_vtable};

// D e f i n e  C l a s s  B
typedef struct {
    metadata *clazz;
} B;



void (*B_vtable[])() = {
};

metadata B_metadata = {"B", sizeof(B), &B_vtable};

int main(int argc, char *argv[])
{
}