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



// D e f i n e  C l a s s  Vehicle
typedef struct {
    metadata *clazz;
} Vehicle;

#define Vehicle_start_SLOT 0
#define Vehicle_getColor_SLOT 1


void Vehicle_start(Vehicle *this)
{
}
int Vehicle_getColor(Vehicle *this)
{
    return 9;
}

void (*Vehicle_vtable[])() = {
    (void (*)())&Vehicle_start,
    (void (*)())&Vehicle_getColor
};

metadata Vehicle_metadata = {"Vehicle", sizeof(Vehicle), &Vehicle_vtable};

// D e f i n e  C l a s s  Car
typedef struct {
    metadata *clazz;
} Car;

#define Car_start_SLOT 0
#define Car_getColor_SLOT 1
#define Car_setDoors_SLOT 2


void Car_start(Car *this)
{
}
void Car_setDoors(Car *this, int n)
{
}

void (*Car_vtable[])() = {
    (void (*)())&Car_start,
    (void (*)())&Vehicle_getColor,
    (void (*)())&Car_setDoors
};

metadata Car_metadata = {"Car", sizeof(Car), &Car_vtable};

// D e f i n e  C l a s s  Truck
typedef struct {
    metadata *clazz;
} Truck;

#define Truck_start_SLOT 0
#define Truck_getColor_SLOT 1
#define Truck_setPayload_SLOT 2


void Truck_start(Truck *this)
{
}
void Truck_setPayload(Truck *this, int n)
{
}

void (*Truck_vtable[])() = {
    (void (*)())&Truck_start,
    (void (*)())&Vehicle_getColor,
    (void (*)())&Truck_setPayload
};

metadata Truck_metadata = {"Truck", sizeof(Truck), &Truck_vtable};

int main(int argc, char *argv[])
{
    Vehicle * v;
    Truck * t;

    t = ((Truck *)alloc(&Truck_metadata));
    v = ((Vehicle *)t);
    (*(void (*)(Truck *))(*(t)->clazz->_vtable)[Truck_start_SLOT])(((Truck *)t));
    (*(void (*)(Truck *,int))(*(t)->clazz->_vtable)[Truck_setPayload_SLOT])(((Truck *)t),32);
    (*(void (*)(Vehicle *))(*(v)->clazz->_vtable)[Vehicle_start_SLOT])(((Vehicle *)v));
}