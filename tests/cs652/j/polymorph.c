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

#define Animal_getID_SLOT 0
#define Animal_speak_SLOT 1


int Animal_getID(Animal *this)
{
    return this->ID;
}
void Animal_speak(Animal *this)
{
    printf("%d\n", (*(int (*)(Animal *))(*(this)->clazz->_vtable)[Animal_getID_SLOT])(((Animal *)this)));
}

void (*Animal_vtable[])() = {
    (void (*)())&Animal_getID,
    (void (*)())&Animal_speak
};

metadata Animal_metadata = {"Animal", sizeof(Animal), &Animal_vtable};

// D e f i n e  C l a s s  Dog
typedef struct {
    metadata *clazz;
    int ID;
} Dog;

#define Dog_getID_SLOT 0
#define Dog_speak_SLOT 1


void Dog_speak(Dog *this)
{
    printf("woof!\n");
}

void (*Dog_vtable[])() = {
    (void (*)())&Animal_getID,
    (void (*)())&Dog_speak
};

metadata Dog_metadata = {"Dog", sizeof(Dog), &Dog_vtable};

int main(int argc, char *argv[])
{
    Animal * a;
    Dog * d;

    d = ((Dog *)alloc(&Dog_metadata));
    a = ((Animal *)d);
    (*(void (*)(Animal *))(*(a)->clazz->_vtable)[Animal_speak_SLOT])(((Animal *)a));
    (*(void (*)(Dog *))(*(d)->clazz->_vtable)[Dog_speak_SLOT])(((Dog *)d));
}