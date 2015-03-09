class T {
    float foo(float x) { return x; }
}

T t;
t = new T();
float y;
y = t.foo(10.5);
printf("%f\n", y);
printf("%f\n", t.foo(1.0));
