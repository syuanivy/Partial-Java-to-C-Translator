class T {
    int x;
    float y;
    void foo() { printf("%d %f\n", x, y); }
}

T t;
t = new T();
t.x = 1;
t.y = 2.05;
t.foo();
