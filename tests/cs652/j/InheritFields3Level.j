class Animal {
    int ID;
}

class Dog extends Animal {
}

class Pekinese extends Dog {
}

Pekinese d;
d = new Pekinese();
d.ID = 5;
printf("%d\n", d.ID);
