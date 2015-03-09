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

#define T_foo_SLOT 0


float T_foo(T *this, float x)
{
    return x;
}

void (*T_vtable[])() = {
    (void (*)())&T_foo
};

metadata T_metadata = {"T", sizeof(T), &T_vtable};

int main(int argc, char *argv[])
{
    T * t;
    float y;

    t = ((T *)alloc(&T_metadata));
    y = (*(float (*)(T *,float))(*(t)->clazz->_vtable)[T_foo_SLOT])(((T *)t),10.5);
    printf("%f\n", y);
    printf("%f\n", (*(float (*)(T *,float))(*(t)->clazz->_vtable)[T_foo_SLOT])(((T *)t),1.0));
}