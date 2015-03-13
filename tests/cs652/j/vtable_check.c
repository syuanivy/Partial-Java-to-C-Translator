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



// D e f i n e  C l a s s  Animal
typedef struct {
    metadata *clazz;
} Animal;

#define Animal_foo_SLOT 0
#define Animal_getID_SLOT 1


int Animal_foo(Animal *this)
{
    return (*(int (*)(Animal *))(*(this)->clazz->_vtable)[Animal_getID_SLOT])(((Animal *)this));
}
int Animal_getID(Animal *this)
{
    return 1;
}

void (*Animal_vtable[])() = {
    (void (*)())&Animal_foo,
    (void (*)())&Animal_getID
};

metadata Animal_metadata = {"Animal", sizeof(Animal), &Animal_vtable};

// D e f i n e  C l a s s  Dog
typedef struct {
    metadata *clazz;
} Dog;

#define Dog_foo_SLOT 0
#define Dog_getID_SLOT 1


int Dog_getID(Dog *this)
{
    return 2;
}

void (*Dog_vtable[])() = {
    (void (*)())&Animal_foo,
    (void (*)())&Dog_getID
};

metadata Dog_metadata = {"Dog", sizeof(Dog), &Dog_vtable};

// D e f i n e  C l a s s  Pekinese
typedef struct {
    metadata *clazz;
} Pekinese;

#define Pekinese_foo_SLOT 0
#define Pekinese_getID_SLOT 1


int Pekinese_getID(Pekinese *this)
{
    return 3;
}

void (*Pekinese_vtable[])() = {
    (void (*)())&Animal_foo,
    (void (*)())&Pekinese_getID
};

metadata Pekinese_metadata = {"Pekinese", sizeof(Pekinese), &Pekinese_vtable};

int main(int argc, char *argv[])
{
    Pekinese * d;

    d = ((Pekinese *)alloc(&Pekinese_metadata));
    printf("%d\n", (*(int (*)(Animal *))(*(d)->clazz->_vtable)[Pekinese_foo_SLOT])(((Animal *)d)));
}