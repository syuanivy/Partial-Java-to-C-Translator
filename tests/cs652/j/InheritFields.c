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
    int ID;
} Animal;



void (*Animal_vtable[])() = {
};

metadata Animal_metadata = {"Animal", sizeof(Animal), &Animal_vtable};

// D e f i n e  C l a s s  Dog
typedef struct {
    metadata *clazz;
    int ID;
} Dog;



void (*Dog_vtable[])() = {
};

metadata Dog_metadata = {"Dog", sizeof(Dog), &Dog_vtable};

int main(int argc, char *argv[])
{
    Dog * d;

    d = ((Dog *)alloc(&Dog_metadata));
    d->ID = 5;
    printf("%d\n", d->ID);
}