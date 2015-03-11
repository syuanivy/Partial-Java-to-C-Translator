class Employee {
    int ID;
    int getID() { return ID; }
    void setID(int ID) { this.ID = ID; }
}
class Coder extends Employee {
    float salary;
    Employee boss;
    void raise(float v) { salary = v; }
    void speak() { printf("I am %d\n", ID); }
    void workFor(Employee e) { boss=e; }
}
int ID;
ID = 1;
Coder c;
c = new Coder();
c.ID = ID;
c.boss = null;
c.speak();
