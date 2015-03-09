class T {
    void foo() { printf("foo\n"); }
    void bar() { printf("bar\n"); }
}

T t;
t = new T();
t.foo();
t.bar();
