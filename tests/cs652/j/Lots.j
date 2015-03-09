class T {
    int x;
    float y;
    void foo() { printf("hi\n"); }
    int bar(int x, T q) {
        printf("%d %d\n", x, q.x);
        int z;
        foo();
        this.foo();
        z = q.x;
        y = 3;
        return y;
    }
}

T t;
t = new T();
t.foo();
t.bar(11, new T());
T u;
u = new T();
u.x = 2;
t.bar(99, u);
