class Animal {
    int ID;
    int getID() { return ID; }
    void speak() { printf("%d\n", getID()); }
}

class Dog extends Animal {
    void speak() { printf("woof!\n"); }
}

Animal a;
Dog d;
d = new Dog();
a = d; // should cast to Animal *
a.speak();
d.speak();