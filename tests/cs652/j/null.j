// test parameters to a function
// no return values are allowed in J
class T {
    void foo(T y) { printf("T.foo %p\n", y); }
}

T t;
t = new T();
t.foo(null);
t = null;
