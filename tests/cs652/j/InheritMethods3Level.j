class Animal {
    int getID() { return 99; }
}

class Dog extends Animal {
    void blort() { }
}

class Pekinese extends Dog {
    int foo() { return getID(); }
    int bar() { return this.getID(); }
}

Pekinese d;
d = new Pekinese();
printf("%d\n", d.getID());
printf("%d\n", d.foo());
printf("%d\n", d.bar());
