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
} T;

#define T_f_SLOT 0


float T_f(T *this)
{
    return 3.14;
}

void (*T_vtable[])() = {
    (void (*)())&T_f
};

metadata T_metadata = {"T", sizeof(T), &T_vtable};

int main(int argc, char *argv[])
{
    T * t;
    float q;

    t = ((T *)alloc(&T_metadata));
    q = (*(float (*)(T *))(*(t)->clazz->_vtable)[T_f_SLOT])(((T *)t));
    printf("%f\n", q);
}