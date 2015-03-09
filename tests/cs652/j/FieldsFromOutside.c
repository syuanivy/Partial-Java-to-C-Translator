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



// D e f i n e  C l a s s  T
typedef struct {
    metadata *clazz;
    int x;
    float y;
} T;



void (*T_vtable[])() = {
};

metadata T_metadata = {"T", sizeof(T), &T_vtable};

int main(int argc, char *argv[])
{
    T * t;

    t = ((T *)alloc(&T_metadata));
    t->x = 1;
    t->y = 2;
    printf("%d %f\n", t->x, t->y);
}