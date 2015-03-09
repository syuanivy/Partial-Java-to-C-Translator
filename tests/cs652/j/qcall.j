class T {
    void foo() { printf("hi\n"); }
    void bar() {
        foo();
        this.foo();
    }
}

T t;
t = new T();
t.bar();
