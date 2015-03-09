class Animal {
    int ID;
    int getID() { return ID; }
    void speak() { printf("blort!\n"); }
}

class Dog extends Animal {
    void speak() { printf("woof!\n"); }
}

Animal a;
a = new Animal();
a.speak();
a.ID = 4;
printf("%d\n", a.getID());

Dog d;
d = new Dog();
d.ID = 5;
d.speak();
printf("%d\n", d.getID());
printf("%d\n", d.ID);
