class Employee {
    int ID;
    int getID() { return ID; }
    void setID(int ID) { this.ID = ID; }
}
class Mgr extends Employee {
    int level;
}
class Coder extends Employee {
    float salary;
    Mgr boss;
    void raise(float v) { salary = v; }
    void speak() { printf("I am %d\n", ID); }
    void workFor(Employee e) { boss=e; }
}
int ID;
ID = 1;
Coder c;
c = new Coder();
c.ID = ID;
c.boss = new Mgr();
c.boss.level = 99;
c.boss.ID = 4;
printf("%d\n", c.boss.getID());
c.speak();
