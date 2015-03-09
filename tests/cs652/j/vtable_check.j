class Animal {
    int getID() { return 1; }
    int foo() { return getID(); }
}

class Dog extends Animal {
    int getID() { return 2; }
}

class Pekinese extends Dog {
    int getID() { return 3; }
}

Pekinese d;
d = new Pekinese();
printf("%d\n", d.foo());
