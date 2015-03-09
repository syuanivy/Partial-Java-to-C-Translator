class Animal {
    int ID;
}

class Dog extends Animal {
}

Dog d;
d = new Dog();
d.ID = 5;
printf("%d\n", d.ID);
