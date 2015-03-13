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



// D e f i n e  C l a s s  Employee
typedef struct {
    metadata *clazz;
    int ID;
} Employee;

#define Employee_getID_SLOT 0
#define Employee_setID_SLOT 1


int Employee_getID(Employee *this)
{
    return this->ID;
}
void Employee_setID(Employee *this, int ID)
{
    this->ID = ID;
}

void (*Employee_vtable[])() = {
    (void (*)())&Employee_getID,
    (void (*)())&Employee_setID
};

metadata Employee_metadata = {"Employee", sizeof(Employee), &Employee_vtable};

// D e f i n e  C l a s s  Mgr
typedef struct {
    metadata *clazz;
    int ID;
    int level;
} Mgr;

#define Mgr_getID_SLOT 0
#define Mgr_setID_SLOT 1



void (*Mgr_vtable[])() = {
    (void (*)())&Employee_getID,
    (void (*)())&Employee_setID
};

metadata Mgr_metadata = {"Mgr", sizeof(Mgr), &Mgr_vtable};

// D e f i n e  C l a s s  Coder
typedef struct {
    metadata *clazz;
    int ID;
    float salary;
    Mgr * boss;
} Coder;

#define Coder_getID_SLOT 0
#define Coder_setID_SLOT 1
#define Coder_raise_SLOT 2
#define Coder_speak_SLOT 3
#define Coder_workFor_SLOT 4


void Coder_raise(Coder *this, float v)
{
    this->salary = v;
}
void Coder_speak(Coder *this)
{
    printf("I am %d\n", this->ID);
}
void Coder_workFor(Coder *this, Employee * e)
{
    this->boss = ((Mgr *)e);
}

void (*Coder_vtable[])() = {
    (void (*)())&Employee_getID,
    (void (*)())&Employee_setID,
    (void (*)())&Coder_raise,
    (void (*)())&Coder_speak,
    (void (*)())&Coder_workFor
};

metadata Coder_metadata = {"Coder", sizeof(Coder), &Coder_vtable};

int main(int argc, char *argv[])
{
    int ID;
    Coder * c;

    ID = 1;
    c = ((Coder *)alloc(&Coder_metadata));
    c->ID = ID;
    c->boss = ((Mgr *)alloc(&Mgr_metadata));
    c->boss->level = 99;
    c->boss->ID = 4;
    printf("%d\n", (*(int (*)(Employee *))(*(c->boss)->clazz->_vtable)[Mgr_getID_SLOT])(((Employee *)c->boss)));
    (*(void (*)(Coder *))(*(c)->clazz->_vtable)[Coder_speak_SLOT])(((Coder *)c));
}