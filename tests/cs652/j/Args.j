// test parameters to a function
// no return values are allowed in J
class T {
    void foo(int x, float y) { printf("%d %f\n", x, y); }
}

T t;
t = new T();
t.foo(34,3.14159);
