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

#define T_foo_SLOT 0
#define T_bar_SLOT 1


void T_foo(T *this)
{
    printf("hi\n");
}
int T_bar(T *this, int x, T * q)
{
    int z;

    printf("%d %d\n", x, q->x);
    (*(void (*)(T *))(*(this)->clazz->_vtable)[T_foo_SLOT])(((T *)this));
    (*(void (*)(T *))(*(this)->clazz->_vtable)[T_foo_SLOT])(((T *)this));
    z = q->x;
    this->y = 3;
    return this->y;
}

void (*T_vtable[])() = {
    (void (*)())&T_foo,
    (void (*)())&T_bar
};

metadata T_metadata = {"T", sizeof(T), &T_vtable};

int main(int argc, char *argv[])
{
    T * t;
    T * u;

    t = ((T *)alloc(&T_metadata));
    (*(void (*)(T *))(*(t)->clazz->_vtable)[T_foo_SLOT])(((T *)t));
    (*(int (*)(T *,int,T *))(*(t)->clazz->_vtable)[T_bar_SLOT])(((T *)t),11,((T *)alloc(&T_metadata)));
    u = ((T *)alloc(&T_metadata));
    u->x = 2;
    (*(int (*)(T *,int,T *))(*(t)->clazz->_vtable)[T_bar_SLOT])(((T *)t),99,((T *)u));
}