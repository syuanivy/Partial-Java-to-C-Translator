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

#define Animal_getID_SLOT 0


int Animal_getID(Animal *this)
{
    return 99;
}

void (*Animal_vtable[])() = {
    (void (*)())&Animal_getID
};

metadata Animal_metadata = {"Animal", sizeof(Animal), &Animal_vtable};

// D e f i n e  C l a s s  Dog
typedef struct {
    metadata *clazz;
} Dog;

#define Dog_getID_SLOT 0
#define Dog_blort_SLOT 1


void Dog_blort(Dog *this)
{
}

void (*Dog_vtable[])() = {
    (void (*)())&Animal_getID,
    (void (*)())&Dog_blort
};

metadata Dog_metadata = {"Dog", sizeof(Dog), &Dog_vtable};

// D e f i n e  C l a s s  Pekinese
typedef struct {
    metadata *clazz;
} Pekinese;

#define Pekinese_getID_SLOT 0
#define Pekinese_blort_SLOT 1
#define Pekinese_foo_SLOT 2
#define Pekinese_bar_SLOT 3


int Pekinese_foo(Pekinese *this)
{
    return (*(int (*)(Animal *))(*(this)->clazz->_vtable)[Pekinese_getID_SLOT])(((Animal *)this));
}
int Pekinese_bar(Pekinese *this)
{
    return (*(int (*)(Animal *))(*(this)->clazz->_vtable)[Pekinese_getID_SLOT])(((Animal *)this));
}

void (*Pekinese_vtable[])() = {
    (void (*)())&Animal_getID,
    (void (*)())&Dog_blort,
    (void (*)())&Pekinese_foo,
    (void (*)())&Pekinese_bar
};

metadata Pekinese_metadata = {"Pekinese", sizeof(Pekinese), &Pekinese_vtable};

int main(int argc, char *argv[])
{
    Pekinese * d;

    d = ((Pekinese *)alloc(&Pekinese_metadata));
    printf("%d\n", (*(int (*)(Animal *))(*(d)->clazz->_vtable)[Pekinese_getID_SLOT])(((Animal *)d)));
    printf("%d\n", (*(int (*)(Pekinese *))(*(d)->clazz->_vtable)[Pekinese_foo_SLOT])(((Pekinese *)d)));
    printf("%d\n", (*(int (*)(Pekinese *))(*(d)->clazz->_vtable)[Pekinese_bar_SLOT])(((Pekinese *)d)));
}