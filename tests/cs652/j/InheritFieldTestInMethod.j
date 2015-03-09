class Animal {
    int ID;
}

class Dog extends Animal {
    void speak() { printf("%d\n", ID); }
    void speak2() { printf("%d\n", this.ID); }
}

Dog d;
d = new Dog();
d.ID = 5;
d.speak();
d.speak2();

